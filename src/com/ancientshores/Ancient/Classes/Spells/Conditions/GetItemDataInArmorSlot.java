package com.ancientshores.Ancient.Classes.Spells.Conditions;

import com.ancientshores.Ancient.Classes.Spells.ArgumentDescription;
import com.ancientshores.Ancient.Classes.Spells.ParameterType;
import com.ancientshores.Ancient.Classes.Spells.SpellInformationObject;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

public class GetItemDataInArmorSlot
  extends IArgument
{
  @ArgumentDescription(description="Returns the data of the item in the specified armor slot", parameterdescription={"player", "slot"}, returntype=ParameterType.Number, rparams={ParameterType.Player, ParameterType.Number})
  public GetItemDataInArmorSlot()
  {
    this.returnType = ParameterType.Number;
    this.requiredTypes = new ParameterType[] { ParameterType.Player, ParameterType.Number };
    this.name = "getitemdatainarmorslot";
  }
  
  public Object getArgument(Object[] obj, SpellInformationObject so)
  {
    if ((obj.length == 2) && ((obj[0] instanceof Entity[])) && ((obj[1] instanceof Number)))
    {
      Entity[] ents = (Entity[])obj[0];
      int slot = ((Number)obj[1]).intValue();
      if ((ents.length < 0) || (ents[0] == null)) {
        return null;
      }
      LivingEntity ent = (LivingEntity)ents[0];
      switch (slot)
      {
      case 0: 
        return Integer.valueOf(ent.getEquipment().getHelmet().getData().getData());
      case 1: 
        return Integer.valueOf(ent.getEquipment().getChestplate().getData().getData());
      case 2: 
        return Integer.valueOf(ent.getEquipment().getLeggings().getData().getData());
      case 3: 
        return Integer.valueOf(ent.getEquipment().getBoots().getData().getData());
      }
    }
    return null;
  }
}


/* Location:              C:\Users\Jens\Desktop\Spigot Server\plugins\Ancient_v1.1.0 (1).jar!\com\ancientshores\Ancient\Classes\Spells\Conditions\GetItemDataInArmorSlot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */