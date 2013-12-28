package com.ancientshores.AncientRPG.Guild.Commands;

import com.ancientshores.AncientRPG.AncientRPG;
import com.ancientshores.AncientRPG.Guild.AncientRPGGuild;
import com.ancientshores.AncientRPG.Guild.AncientRPGGuildRanks;
import com.ancientshores.AncientRPG.Util.SerializableLocation;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GuildSetSpawnCommand {
    public static void setGuildSpawnCommand(CommandSender sender) {
        AncientRPGGuild mGuild = AncientRPGGuild.getPlayersGuild(sender.getName());
        if (mGuild != null) {
            AncientRPGGuildRanks rank = mGuild.gMember.get(sender.getName());
            if (rank == AncientRPGGuildRanks.LEADER || rank == AncientRPGGuildRanks.CO_LEADER) {
                if (AncientRPGGuild.spawnEnabled && sender instanceof Player) {
                    mGuild.spawnLocation = new SerializableLocation(((Player) sender).getLocation());
                    sender.sendMessage(AncientRPG.brand2 + "Successfully set the guildspawn to your current location");
                    AncientRPGGuild.writeGuild(mGuild);
                } else {
                    sender.sendMessage(AncientRPG.brand2 + "The spawn feature is not enabled on this server");
                }
            } else {
                sender.sendMessage(AncientRPG.brand2 + "You have to be atleast a coleader to use this command");
            }
        } else {
            sender.sendMessage(AncientRPG.brand2 + "You have to be in a guild to use this command");
        }
    }
}