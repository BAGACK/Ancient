package com.ancientshores.Ancient.Classes.Spells.Commands.Effects;

import com.ancientshores.Ancient.Ancient;
import com.ancientshores.Ancient.Classes.Spells.CommandDescription;
import com.ancientshores.Ancient.Classes.Spells.Commands.EffectArgs;
import com.ancientshores.Ancient.Classes.Spells.Commands.ICommand;
import com.ancientshores.Ancient.Classes.Spells.ParameterType;
import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.effect.FlameEffect;
import java.util.LinkedList;
import org.bukkit.Location;

public class Flame
  extends ICommand
{
  @CommandDescription(description="<html>Creates flames at the given location</html>", argnames={"location", "period", "iterations"}, name="Flame", parameters={ParameterType.Location, ParameterType.Number, ParameterType.Number})
  public Flame()
  {
    this.paramTypes = new ParameterType[] { ParameterType.Location, ParameterType.Number, ParameterType.Number };
  }
  
  public boolean playCommand(EffectArgs ca)
  {
    if ((ca.getParams().size() == 3) && ((ca.getParams().get(2) instanceof Number)) && ((ca.getParams().get(1) instanceof Number)) && ((ca.getParams().get(0) instanceof Location[])))
    {
      EffectManager man = new EffectManager(Ancient.effectLib);
      
      Location[] loc = (Location[])ca.getParams().get(0);
      
      int period = ((Number)ca.getParams().get(1)).intValue();
      
      int iterations = ((Number)ca.getParams().get(2)).intValue();
      if ((loc != null) && (loc.length > 0)) {
        for (Location l : loc) {
          if (l != null)
          {
            FlameEffect e = new FlameEffect(man);
            e.period = period;
            e.iterations = iterations;
            
            e.setLocation(l);
            e.start();
          }
        }
      }
      man.disposeOnTermination();
      return true;
    }
    return false;
  }
}


/* Location:              C:\Users\Jens\Desktop\Spigot Server\plugins\Ancient_v1.1.0 (1).jar!\com\ancientshores\Ancient\Classes\Spells\Commands\Effects\Flame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */