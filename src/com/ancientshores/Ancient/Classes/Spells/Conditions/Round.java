package com.ancientshores.Ancient.Classes.Spells.Conditions;

import com.ancientshores.Ancient.Classes.Spells.ArgumentDescription;
import com.ancientshores.Ancient.Classes.Spells.ParameterType;
import com.ancientshores.Ancient.Classes.Spells.SpellInformationObject;

public class Round
  extends IArgument
{
  @ArgumentDescription(description="Rounds the specified number", parameterdescription={"number"}, returntype=ParameterType.Number, rparams={ParameterType.Number})
  public Round()
  {
    this.returnType = ParameterType.Number;
    this.requiredTypes = new ParameterType[] { ParameterType.Number };
    this.name = "round";
  }
  
  public Object getArgument(Object[] obj, SpellInformationObject so)
  {
    if ((obj.length != 1) || (!(obj[0] instanceof Number))) {
      return Integer.valueOf(0);
    }
    return Integer.valueOf(Math.round((int)Math.round(((Number)obj[0]).doubleValue())));
  }
}


/* Location:              C:\Users\Jens\Desktop\Spigot Server\plugins\Ancient_v1.1.0 (1).jar!\com\ancientshores\Ancient\Classes\Spells\Conditions\Round.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */