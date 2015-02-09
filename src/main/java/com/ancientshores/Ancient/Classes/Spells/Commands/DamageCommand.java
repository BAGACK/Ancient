package com.ancientshores.Ancient.Classes.Spells.Commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import com.ancientshores.Ancient.Ancient;
import com.ancientshores.Ancient.Classes.Spells.CommandDescription;
import com.ancientshores.Ancient.Classes.Spells.ParameterType;
import com.ancientshores.Ancient.Listeners.AncientEntityListener;

public class DamageCommand extends ICommand {

    @CommandDescription(description = "<html>Damages the targeted entity with the specified damage</html>",
            argnames = {"entity", "damage"}, name = "Damage", parameters = {ParameterType.Entity, ParameterType.Number})
    public DamageCommand() {
        this.paramTypes = new ParameterType[]{ParameterType.Entity, ParameterType.Number};
    }

    @Override
    public boolean playCommand(final EffectArgs ca) {
        try {
            if (ca.getParams().get(0) instanceof Entity[] && ca.getParams().get(1) instanceof Number) {
                final Entity[] target = (Entity[]) ca.getParams().get(0);
                double damage = ((Number) ca.getParams().get(1)).floatValue();
                if (target != null && target.length > 0 && target[0] instanceof Entity) {
                    for (final Entity targetPlayer : target) {
                        if (targetPlayer == null || !(targetPlayer instanceof LivingEntity)) {
                            continue;
                        }
                        EntityDamageByEntityEvent event = new EntityDamageByEntityEvent(ca.getCaster(), targetPlayer, DamageCause.CUSTOM, damage); 
                        
                        Bukkit.getPluginManager().callEvent(event);
                        
                        if (event.isCancelled())
                        	continue;
                        
                        AncientEntityListener.scheduledXpList.put(targetPlayer.getUniqueId(), ca.getCaster().getUniqueId());
                        Ancient.plugin.scheduleThreadSafeTask(Ancient.plugin, new Runnable() {
                            @Override
                            public void run() {
                                AncientEntityListener.scheduledXpList.remove(targetPlayer.getUniqueId());
                            }
                        }, Math.round(1000 / 50));
                    }

                    return true;
                }
            }
        } catch (IndexOutOfBoundsException ignored) {

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}