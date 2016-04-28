package com.ancientshores.Ancient.Classes.Spells.Commands;

import com.ancientshores.Ancient.Classes.Spells.CommandDescription;
import com.ancientshores.Ancient.Classes.Spells.ParameterType;
import java.util.LinkedList;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;

public class DropItemCommand
  extends ICommand
{
  @CommandDescription(description="<html>Drops the specified amount of items at the location</html>", argnames={"location", "material", "amount"}, name="DropItem", parameters={ParameterType.Location, ParameterType.Material, ParameterType.Number})
  public DropItemCommand()
  {
    this.paramTypes = new ParameterType[] { ParameterType.Location, ParameterType.Material, ParameterType.Number };
  }
  
  public boolean playCommand(EffectArgs ca)
  {
    if ((ca.getParams().size() == 3) && ((ca.getParams().get(0) instanceof Location[])) && ((ca.getParams().get(1) instanceof Material)) && ((ca.getParams().get(2) instanceof Number)))
    {
      Location[] locs = (Location[])ca.getParams().get(0);
      Material mat = (Material)ca.getParams().get(1);
      int amount = (int)((Number)ca.getParams().get(2)).doubleValue();
      for (Location l : locs) {
        while (amount > 0)
        {
          int remove;
          if (amount > 64)
          {
            int remove = 64;
            amount -= 64;
          }
          else
          {
            remove = amount;
            amount = 0;
          }
          ItemStack is = new ItemStack(mat, remove);
          l.getWorld().dropItem(l, is);
        }
      }
      return true;
    }
    return false;
  }
}


/* Location:              C:\Users\Jens\Desktop\Spigot Server\plugins\Ancient_v1.1.0 (1).jar!\com\ancientshores\Ancient\Classes\Spells\Commands\DropItemCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */