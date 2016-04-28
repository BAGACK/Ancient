package com.ancientshores.Ancient.Classes.Spells.Conditions;

import com.ancientshores.Ancient.Classes.Spells.ArgumentDescription;
import com.ancientshores.Ancient.Classes.Spells.ParameterType;
import com.ancientshores.Ancient.Classes.Spells.SpellInformationObject;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class GetItemAmountInItemSlot
  extends IArgument
{
  @ArgumentDescription(description="Returns the amount of items in the specified item slot", parameterdescription={"player", "slot"}, returntype=ParameterType.Number, rparams={ParameterType.Player, ParameterType.Number})
  public GetItemAmountInItemSlot()
  {
    this.returnType = ParameterType.Number;
    this.requiredTypes = new ParameterType[] { ParameterType.Player, ParameterType.Number };
    this.name = "getitemamountinitemslot";
  }
  
  public Object getArgument(Object[] obj, SpellInformationObject so)
  {
    if ((obj.length == 2) && ((obj[0] instanceof Player[])) && (((Player[])(Player[])obj[0])[0] != null) && ((obj[1] instanceof Number)))
    {
      Player p = ((Player[])(Player[])obj[0])[0];
      int slot = (int)((Number)obj[1]).doubleValue();
      if (p.getInventory().getItem(slot) == null) {
        return Integer.valueOf(0);
      }
      return Integer.valueOf(p.getInventory().getItem(slot).getAmount());
    }
    return null;
  }
}


/* Location:              C:\Users\Jens\Desktop\Spigot Server\plugins\Ancient_v1.1.0 (1).jar!\com\ancientshores\Ancient\Classes\Spells\Conditions\GetItemAmountInItemSlot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */