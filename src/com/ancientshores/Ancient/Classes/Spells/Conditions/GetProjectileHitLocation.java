package com.ancientshores.Ancient.Classes.Spells.Conditions;

import com.ancientshores.Ancient.Classes.Spells.ArgumentDescription;
import com.ancientshores.Ancient.Classes.Spells.ParameterType;
import com.ancientshores.Ancient.Classes.Spells.SpellInformationObject;
import org.bukkit.Location;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.ProjectileHitEvent;

public class GetProjectileHitLocation
  extends IArgument
{
  @ArgumentDescription(description="Returns the location the projectile hit, only usable in projectilehitevent", parameterdescription={}, returntype=ParameterType.Location, rparams={})
  public GetProjectileHitLocation()
  {
    this.returnType = ParameterType.Location;
    this.requiredTypes = new ParameterType[0];
    this.name = "getprojectilehitlocation";
  }
  
  public Object getArgument(Object[] obj, SpellInformationObject so)
  {
    if ((so.mEvent instanceof ProjectileHitEvent))
    {
      ProjectileHitEvent pEvent = (ProjectileHitEvent)so.mEvent;
      return new Location[] { pEvent.getEntity().getLocation() };
    }
    return null;
  }
}
