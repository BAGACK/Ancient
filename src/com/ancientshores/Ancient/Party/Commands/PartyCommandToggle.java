package com.ancientshores.Ancient.Party.Commands;

import com.ancientshores.Ancient.Ancient;
import com.ancientshores.Ancient.Listeners.AncientPlayerListener;
import java.util.Collection;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PartyCommandToggle
{
  public static void processToggle(CommandSender sender)
  {
    Player mPlayer = (Player)sender;
    if (!AncientPlayerListener.togglepartylist.contains(mPlayer.getUniqueId()))
    {
      AncientPlayerListener.togglepartylist.add(mPlayer.getUniqueId());
      mPlayer.sendMessage(Ancient.brand2 + "Party chat activated");
    }
    else
    {
      AncientPlayerListener.togglepartylist.remove(mPlayer.getUniqueId());
      mPlayer.sendMessage(Ancient.brand2 + "Party chat deacticated");
    }
  }
}
