package com.ancientshores.Ancient.Classes.Spells.Conditions;

import com.ancientshores.Ancient.Classes.Spells.ArgumentDescription;
import com.ancientshores.Ancient.Classes.Spells.ParameterType;
import com.ancientshores.Ancient.Classes.Spells.SpellInformationObject;
import com.ancientshores.Ancient.PlayerData;
import org.bukkit.entity.Player;

public class GetClassName
  extends IArgument
{
  @ArgumentDescription(description="Returns the name of the players class", parameterdescription={"player"}, returntype=ParameterType.String, rparams={ParameterType.Player})
  public GetClassName()
  {
    this.returnType = ParameterType.String;
    this.requiredTypes = new ParameterType[] { ParameterType.Player };
    this.name = "getclassname";
  }
  
  public Object getArgument(Object[] obj, SpellInformationObject so)
  {
    if (!(obj[0] instanceof Player[])) {
      return null;
    }
    Player mPlayer = ((Player[])(Player[])obj[0])[0];
    PlayerData pd = PlayerData.getPlayerData(mPlayer.getUniqueId());
    String classname = pd.getClassName();
    return classname;
  }
}


/* Location:              C:\Users\Jens\Desktop\Spigot Server\plugins\Ancient_v1.1.0 (1).jar!\com\ancientshores\Ancient\Classes\Spells\Conditions\GetClassName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */