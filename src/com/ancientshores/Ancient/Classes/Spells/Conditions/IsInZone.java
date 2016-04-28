package com.ancientshores.Ancient.Classes.Spells.Conditions;

import com.ancientshores.Ancient.Classes.Spells.ArgumentDescription;
import com.ancientshores.Ancient.Classes.Spells.ParameterType;
import com.ancientshores.Ancient.Classes.Spells.SpellInformationObject;
import org.bukkit.Location;

public class IsInZone
  extends IArgument
{
  @ArgumentDescription(description="Returns true if the location is in a zone specified by 2 other locations", parameterdescription={"target", "start", "end"}, returntype=ParameterType.Number, rparams={ParameterType.Location, ParameterType.Location, ParameterType.Location})
  public IsInZone()
  {
    this.returnType = ParameterType.Number;
    this.requiredTypes = new ParameterType[] { ParameterType.Location, ParameterType.Location, ParameterType.Location };
    this.name = "isinzone";
  }
  
  public Object getArgument(Object[] obj, SpellInformationObject so)
  {
    if ((obj.length == 3) && ((obj[0] instanceof Location[])) && ((obj[1] instanceof Location[])) && ((obj[2] instanceof Location[])))
    {
      Location target = ((Location[])(Location[])obj[0])[0];
      Location start = ((Location[])(Location[])obj[1])[0];
      Location end = ((Location[])(Location[])obj[2])[0];
      if ((end.getWorld() != target.getWorld()) || (start.getWorld() != end.getWorld())) {
        return Boolean.valueOf(false);
      }
      int startx = start.getBlockX();
      int endx = end.getBlockX();
      if (startx > endx)
      {
        int buffer = startx;
        startx = endx;
        endx = buffer;
      }
      int starty = start.getBlockY();
      int endy = end.getBlockY();
      if (starty > endy)
      {
        int buffer = starty;
        starty = endy;
        endy = buffer;
      }
      int startz = start.getBlockZ();
      int endz = end.getBlockZ();
      if (startz > endz)
      {
        int buffer = startz;
        startz = endz;
        endz = buffer;
      }
      start = new Location(start.getWorld(), startx, starty, startz);
      end = new Location(start.getWorld(), endx, endy, endz);
      boolean s = (target.getX() > start.getX()) && (target.getY() > start.getY()) && (target.getZ() > start.getZ());
      boolean e = (target.getX() < end.getX()) && (target.getY() < end.getY()) && (target.getZ() < end.getZ());
      return Boolean.valueOf((s) && (e));
    }
    return Boolean.valueOf(false);
  }
}


/* Location:              C:\Users\Jens\Desktop\Spigot Server\plugins\Ancient_v1.1.0 (1).jar!\com\ancientshores\Ancient\Classes\Spells\Conditions\IsInZone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */