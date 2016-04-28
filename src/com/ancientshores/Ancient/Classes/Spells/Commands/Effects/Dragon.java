package com.ancientshores.Ancient.Classes.Spells.Commands.Effects;

import com.ancientshores.Ancient.Ancient;
import com.ancientshores.Ancient.Classes.Spells.CommandDescription;
import com.ancientshores.Ancient.Classes.Spells.Commands.EffectArgs;
import com.ancientshores.Ancient.Classes.Spells.Commands.ICommand;
import com.ancientshores.Ancient.Classes.Spells.ParameterType;
import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.effect.DragonEffect;
import de.slikey.effectlib.util.ParticleEffect;
import java.util.LinkedList;
import org.bukkit.Location;

public class Dragon
  extends ICommand
{
  @CommandDescription(description="<html>Creates a dragon at the given location</html>", argnames={"location", "particlename", "arc pitch", "arcs", "particles per arc", "steps per iteration", "length in blocks", "period", "iterations"}, name="Dragon", parameters={ParameterType.Location, ParameterType.String, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number})
  public Dragon()
  {
    this.paramTypes = new ParameterType[] { ParameterType.Location, ParameterType.String, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number };
  }
  
  public boolean playCommand(EffectArgs ca)
  {
    if ((ca.getParams().size() == 9) && ((ca.getParams().get(8) instanceof Number)) && ((ca.getParams().get(7) instanceof Number)) && ((ca.getParams().get(6) instanceof Number)) && ((ca.getParams().get(5) instanceof Number)) && ((ca.getParams().get(4) instanceof Number)) && ((ca.getParams().get(3) instanceof Number)) && ((ca.getParams().get(2) instanceof Number)) && ((ca.getParams().get(1) instanceof String)) && ((ca.getParams().get(0) instanceof Location[])))
    {
      EffectManager man = new EffectManager(Ancient.effectLib);
      
      Location[] loc = (Location[])ca.getParams().get(0);
      
      ParticleEffect particle = ParticleEffect.fromName((String)ca.getParams().get(1));
      
      float arcPitch = ((Number)ca.getParams().get(2)).floatValue();
      
      int arcs = ((Number)ca.getParams().get(3)).intValue();
      int particlesPerArc = ((Number)ca.getParams().get(4)).intValue();
      
      int stepsPerIteration = ((Number)ca.getParams().get(5)).intValue();
      
      float length = ((Number)ca.getParams().get(6)).floatValue();
      
      int period = ((Number)ca.getParams().get(7)).intValue();
      int iterations = ((Number)ca.getParams().get(8)).intValue();
      if ((loc != null) && (loc.length > 0)) {
        for (Location l : loc) {
          if (l != null)
          {
            DragonEffect e = new DragonEffect(man);
            
            e.particle = particle;
            
            e.pitch = arcPitch;
            e.arcs = arcs;
            e.particles = particlesPerArc;
            
            e.stepsPerIteration = stepsPerIteration;
            
            e.length = length;
            
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
