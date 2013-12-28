package com.ancientshores.AncientRPG.Classes.Spells.Commands;

import com.ancientshores.AncientRPG.AncientRPG;
import com.ancientshores.AncientRPG.Classes.Spells.CommandDescription;
import com.ancientshores.AncientRPG.Classes.Spells.ParameterType;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Fireball;

public class FireBallCommand extends ICommand {
    @CommandDescription(description = "<html>the caster throws a fireball</html>",
            argnames = {}, name = "Fireball", parameters = {})
    public FireBallCommand() {
        ParameterType[] buffer = {};
        this.paramTypes = buffer;
    }

    @Override
    public boolean playCommand(final EffectArgs ca) {
        AncientRPG.plugin.scheduleThreadSafeTask(AncientRPG.plugin, new Runnable() {
            public void run() {
                Location loc = ca.caster.getLocation().add(ca.caster.getLocation().getDirection().normalize().multiply(2));
                final Fireball f = ca.caster.getWorld().spawn(loc.add(new Location(ca.caster.getWorld(), 0, 1, 0)), Fireball.class);
                f.setShooter(ca.caster);
                f.setVelocity(ca.caster.getLocation().getDirection().normalize().multiply(3));
                Bukkit.getScheduler().scheduleSyncDelayedTask(AncientRPG.plugin, new Runnable() {
                    public void run() {
                        f.remove();
                    }
                }, 250);
            }
        });
        return true;
    }
}