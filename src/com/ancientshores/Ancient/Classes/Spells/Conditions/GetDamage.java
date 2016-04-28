package com.ancientshores.Ancient.Classes.Spells.Conditions;

import com.ancientshores.Ancient.Classes.Spells.ArgumentDescription;
import com.ancientshores.Ancient.Classes.Spells.ParameterType;
import com.ancientshores.Ancient.Classes.Spells.SpellInformationObject;
import org.bukkit.event.entity.EntityDamageEvent;

public class GetDamage
  extends IArgument
{
  @ArgumentDescription(description="returns the damage of the damage event", parameterdescription={}, returntype=ParameterType.Number, rparams={})
  public GetDamage()
  {
    this.returnType = ParameterType.Number;
    this.requiredTypes = new ParameterType[0];
    this.name = "getdamage";
  }
  
  public Object getArgument(Object[] obj, SpellInformationObject so)
  {
    if ((so.mEvent instanceof EntityDamageEvent))
    {
      EntityDamageEvent event = (EntityDamageEvent)so.mEvent;
      return Double.valueOf(event.getDamage());
    }
    return null;
  }
}
