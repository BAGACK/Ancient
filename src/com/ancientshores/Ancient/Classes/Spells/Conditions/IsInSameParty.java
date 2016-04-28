package com.ancientshores.Ancient.Classes.Spells.Conditions;

import com.ancientshores.Ancient.Classes.Spells.ArgumentDescription;
import com.ancientshores.Ancient.Classes.Spells.ParameterType;
import com.ancientshores.Ancient.Classes.Spells.SpellInformationObject;
import com.ancientshores.Ancient.Party.AncientParty;
import org.bukkit.entity.Player;

public class IsInSameParty
  extends IArgument
{
  @ArgumentDescription(description="Returns true if the 2 players are in the same party, false otherwise", parameterdescription={"player1", "player2"}, returntype=ParameterType.Boolean, rparams={ParameterType.Player, ParameterType.Player})
  public IsInSameParty()
  {
    this.returnType = ParameterType.Boolean;
    this.requiredTypes = new ParameterType[] { ParameterType.Player, ParameterType.Player };
    this.name = "isinsameparty";
  }
  
  public Object getArgument(Object[] obj, SpellInformationObject so)
  {
    if ((!(obj[0] instanceof Player[])) || (!(obj[1] instanceof Player[]))) {
      return null;
    }
    if ((((Player[])obj[0]).length > 0) && (((Player[])obj[1]).length > 0) && (((Player[])(Player[])obj[0])[0] != null) && (((Player[])(Player[])obj[1])[0] != null))
    {
      Player p1 = ((Player[])(Player[])obj[0])[0];
      Player p2 = ((Player[])(Player[])obj[1])[0];
      AncientParty party1 = AncientParty.getPlayersParty(p1.getUniqueId());
      AncientParty party2 = AncientParty.getPlayersParty(p2.getUniqueId());
      if ((party1 != null) && (party1 == party2)) {
        return Boolean.valueOf(true);
      }
    }
    return Boolean.valueOf(false);
  }
}


/* Location:              C:\Users\Jens\Desktop\Spigot Server\plugins\Ancient_v1.1.0 (1).jar!\com\ancientshores\Ancient\Classes\Spells\Conditions\IsInSameParty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */