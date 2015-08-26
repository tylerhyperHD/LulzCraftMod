package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Bridge.TFM_EssentialsBridge;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerData;
import me.StevenLawson.TotalFreedomMod.TFM_DonatorList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.DONATOR, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Give yourself a color-cycling nick!", usage = "/<command> <nickname>", aliases = "cc")
public class Command_colorcycle extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        TFM_PlayerData playerData = TFM_PlayerData.getPlayerData(sender_p);
        if (args.length != 1)
        {
            playerMsg(ChatColor.GOLD + "Proper usage:");
            playerMsg(ChatColor.GOLD + "/cc on: Makes your current nick a different color every chat message.");
            playerMsg(ChatColor.GOLD + "/cc off: Disables the color-cycling nick.");
            return true;
        }
        if ("off".equals(args[0]))
        {
            playerMsg(ChatColor.GOLD + "Disabled your color-cycling nick.");
            playerData.disableRainbowNick();
            return true;
        }
        if ("on".equals(args[0]))
        {
        String nick = TFM_EssentialsBridge.getNickname(sender.getName());
        playerMsg(ChatColor.GOLD + "Your current nickname, " + nick + ChatColor.GOLD + ", will now change color every chat message. Do /cc off to disable.");
        playerData.enableRainbowNick();
        return true;
        }
        
        return true;
    }
    
    
}
