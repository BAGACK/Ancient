package com.ancientshores.Ancient.Classes.Spells.Commands;

import com.ancientshores.Ancient.Ancient;
import com.ancientshores.Ancient.Classes.AncientClass;
import com.ancientshores.Ancient.Classes.Spells.CommandDescription;
import com.ancientshores.Ancient.Classes.Spells.ParameterType;
import com.ancientshores.Ancient.Classes.Spells.Spell;
import com.ancientshores.Ancient.PlayerData;
import java.util.LinkedList;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

public class ExecuteCommand
  extends ICommand
{
  @CommandDescription(description="<html>Executes the spell</html>", argnames={"player", "spellname"}, name="Execute", parameters={ParameterType.Player, ParameterType.String})
  public ExecuteCommand()
  {
    this.paramTypes = new ParameterType[] { ParameterType.Player, ParameterType.String };
  }
  
  public boolean playCommand(EffectArgs ca)
  {
    try
    {
      if (((ca.getParams().get(0) instanceof Player[])) && ((ca.getParams().get(1) instanceof String)))
      {
        final Player[] pl = (Player[])ca.getParams().get(0);
        final String spellName = (String)ca.getParams().get(1);
        Ancient.plugin.getServer().getScheduler().scheduleSyncDelayedTask(Ancient.plugin, new Runnable()
        {
          public void run()
          {
            for (Player p : pl)
            {
              Spell s = AncientClass.getSpell(spellName, PlayerData.getPlayerData(p.getUniqueId()));
              CommandPlayer.scheduleSpell(s, p.getUniqueId());
            }
          }
        });
        return true;
      }
    }
    catch (IndexOutOfBoundsException ignored) {}
    return false;
  }
}
