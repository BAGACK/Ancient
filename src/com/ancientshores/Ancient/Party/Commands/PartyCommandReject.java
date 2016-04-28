package com.ancientshores.Ancient.Party.Commands;

import com.ancientshores.Ancient.Ancient;
import com.ancientshores.Ancient.Party.AncientParty;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PartyCommandReject
{
  public static void processReject(CommandSender sender)
  {
    Player mPlayer = (Player)sender;
    if (AncientParty.invites.containsKey(mPlayer.getUniqueId()))
    {
      ((AncientParty)AncientParty.invites.get(mPlayer.getUniqueId())).sendMessage(Ancient.brand2 + ChatColor.GOLD + mPlayer.getName() + ChatColor.BLUE + " rejected your invite.");
      AncientParty.invites.remove(mPlayer.getUniqueId());
    }
    else
    {
      mPlayer.sendMessage(Ancient.brand2 + ChatColor.BLUE + "You weren't invited in a party.");
    }
  }
}
