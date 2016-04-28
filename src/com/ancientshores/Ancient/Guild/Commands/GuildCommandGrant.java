package com.ancientshores.Ancient.Guild.Commands;

import com.ancientshores.Ancient.Ancient;
import com.ancientshores.Ancient.Guild.AncientGuild;
import com.ancientshores.Ancient.Guild.AncientGuildRanks;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GuildCommandGrant
{
  public static void processGrant(CommandSender sender, String[] args)
  {
    Player mPlayer = (Player)sender;
    if (args.length == 3)
    {
      AncientGuild mGuild = AncientGuild.getPlayersGuild(mPlayer.getUniqueId());
      if (mGuild != null)
      {
        Player grantedplayer = Bukkit.getPlayer(args[1]);
        if ((grantedplayer != null) && (grantedplayer.isOnline()) && (mGuild.gMember.containsKey(grantedplayer.getUniqueId())))
        {
          AncientGuildRanks newrank = AncientGuildRanks.getRankByString(args[2]);
          if (newrank != null) {
            switch ((AncientGuildRanks)mGuild.gMember.get(mPlayer.getUniqueId()))
            {
            case LEADER: 
              if ((newrank == AncientGuildRanks.LEADER) && (grantedplayer != mPlayer))
              {
                mGuild.gLeader = grantedplayer.getUniqueId();
                mGuild.gMember.put(grantedplayer.getUniqueId(), AncientGuildRanks.LEADER);
                mGuild.gMember.put(mPlayer.getUniqueId(), AncientGuildRanks.CO_LEADER);
                mGuild.broadcastMessage(Ancient.brand2 + ChatColor.GREEN + "<Guild>: " + ChatColor.DARK_RED + grantedplayer.getName() + ChatColor.GREEN + " is the new Leader of the guild.");
                return;
              }
              if (grantedplayer != mPlayer)
              {
                mGuild.gMember.put(grantedplayer.getUniqueId(), newrank);
                mGuild.broadcastMessage(Ancient.brand2 + ChatColor.GREEN + "<Guild>: " + AncientGuildRanks.getChatColorByRank(newrank) + grantedplayer.getName() + AncientGuildRanks.getChatColorByRank(newrank) + ChatColor.GREEN + " is now a " + newrank.getGuildRank() + ".");
              }
              return;
            case CO_LEADER: 
              if ((newrank == AncientGuildRanks.MEMBER) || (newrank == AncientGuildRanks.OFFICER) || (newrank == AncientGuildRanks.TRIAL))
              {
                mGuild.gMember.put(grantedplayer.getUniqueId(), newrank);
                mGuild.broadcastMessage(Ancient.brand2 + ChatColor.GREEN + "<Guild>: " + grantedplayer.getName() + AncientGuildRanks.getChatColorByRank(newrank) + ChatColor.GREEN + " is now a " + newrank.getGuildRank() + ".");
              }
              else
              {
                mPlayer.sendMessage(Ancient.brand2 + ChatColor.GREEN + "You haven't the rights to do that.");
              }
              return;
            case OFFICER: 
              if ((newrank == AncientGuildRanks.MEMBER) || (newrank == AncientGuildRanks.OFFICER) || (newrank == AncientGuildRanks.TRIAL))
              {
                mGuild.gMember.put(grantedplayer.getUniqueId(), newrank);
                mGuild.broadcastMessage(Ancient.brand2 + ChatColor.GREEN + "<Guild>: " + grantedplayer.getName() + AncientGuildRanks.getChatColorByRank(newrank) + ChatColor.GREEN + " is now a " + newrank.getGuildRank() + ".");
              }
              else
              {
                mPlayer.sendMessage(Ancient.brand2 + ChatColor.GREEN + "You haven't the rights to do that.");
              }
              return;
            }
          } else {
            mPlayer.sendMessage(Ancient.brand2 + ChatColor.RED + "This rank doesn't exist.");
          }
        }
        else
        {
          mPlayer.sendMessage(Ancient.brand2 + ChatColor.RED + "This player doesn't exist, isn't in your guild or isn't online.");
        }
      }
      else
      {
        mPlayer.sendMessage(Ancient.brand2 + ChatColor.RED + "You are in no guild");
      }
    }
    else
    {
      mPlayer.sendMessage(Ancient.brand2 + ChatColor.RED + "Correct usage /guild grant <name> <rank>");
    }
  }
}


/* Location:              C:\Users\Jens\Desktop\Spigot Server\plugins\Ancient_v1.1.0 (1).jar!\com\ancientshores\Ancient\Guild\Commands\GuildCommandGrant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */