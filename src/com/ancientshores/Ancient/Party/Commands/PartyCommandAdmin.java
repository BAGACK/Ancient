package com.ancientshores.Ancient.Party.Commands;

import com.ancient.util.PlayerFinder;
import com.ancientshores.Ancient.Ancient;
import com.ancientshores.Ancient.Party.AncientParty;
import java.util.Collection;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PartyCommandAdmin
{
  public static void processAdmin(CommandSender sender, String[] args, Ancient main)
  {
    Player mPlayer = (Player)sender;
    if (mPlayer.hasPermission("Ancient.party.admin"))
    {
      int i;
      if ((args.length == 2) && 
        (args[1].equals("show")))
      {
        i = 1;
        for (AncientParty p : AncientParty.partys)
        {
          mPlayer.sendMessage(ChatColor.BLUE + "" + i + ": " + ChatColor.GREEN + PlayerFinder.getPlayerName(p.getLeader()));
          i++;
        }
      }
      if (args.length == 3) {
        if (args[1].equals("pl"))
        {
          Player playertolist = Bukkit.getPlayer(args[2]);
          if (playertolist != null) {
            if (AncientParty.getPlayersParty(playertolist.getUniqueId()) != null)
            {
              AncientParty mParty = AncientParty.getPlayersParty(playertolist.getUniqueId());
              mPlayer.sendMessage(Ancient.brand2 + ChatColor.BLUE + "In this party are:");
              for (UUID uuid : mParty.getMembers()) {
                if (uuid != null) {
                  if (uuid.compareTo(AncientParty.getPlayersParty(mPlayer.getUniqueId()).getLeader()) == 0) {
                    mPlayer.sendMessage(ChatColor.GREEN + PlayerFinder.getPlayerName(uuid) + "(Leader)");
                  } else {
                    mPlayer.sendMessage(ChatColor.GOLD + PlayerFinder.getPlayerName(uuid));
                  }
                }
              }
            }
            else
            {
              mPlayer.sendMessage(ChatColor.BLUE + "This user isn't in a Party");
            }
          }
        }
        else if (args[1].equals("db"))
        {
          Player playertolist = Bukkit.getPlayer(args[2]);
          if (playertolist != null)
          {
            if (AncientParty.getPlayersParty(playertolist.getUniqueId()) != null)
            {
              AncientParty mParty = AncientParty.getPlayersParty(playertolist.getUniqueId());
              mParty.sendMessage(Ancient.brand2 + ChatColor.BLUE + "Your party has been disbandend by an admin.");
              mParty.removeAll();
              AncientParty.partys.remove(mParty);
            }
            else
            {
              mPlayer.sendMessage(Ancient.brand2 + ChatColor.BLUE + "This user isn't in a Party");
            }
          }
          else {
            mPlayer.sendMessage(Ancient.brand2 + ChatColor.BLUE + "This player isn't in a party.");
          }
        }
      }
    }
    else
    {
      mPlayer.sendMessage(Ancient.brand2 + ChatColor.BLUE + "You aren't a party admin");
    }
  }
}


/* Location:              C:\Users\Jens\Desktop\Spigot Server\plugins\Ancient_v1.1.0 (1).jar!\com\ancientshores\Ancient\Party\Commands\PartyCommandAdmin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */