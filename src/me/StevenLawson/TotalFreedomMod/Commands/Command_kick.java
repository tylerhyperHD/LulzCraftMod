package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Bridge.TFM_WorldEditBridge;
import me.StevenLawson.TotalFreedomMod.TFM_Ban;
import me.StevenLawson.TotalFreedomMod.TFM_BanManager;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TFM_UuidManager;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class Command_kick extends TFM_Command
{
        @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length == 0)
        {
            return false;
        }
        final Player player = getPlayer(args[0]);

        if (player == null)
        {
            playerMsg(TFM_Command.PLAYER_NOT_FOUND, ChatColor.RED);
            return true;
        }    
        String reason = null;
        if (args.length >= 2)
        {
            reason = StringUtils.join(ArrayUtils.subarray(args, 1, args.length), " ");
        }
        TFM_Util.adminAction(sender.getName(), "Kicking player: " + player.getName() + ".", true);
        if (reason != null)
        {
            TFM_Util.bcastMsg(ChatColor.RED + "Reason: " + reason);
        }
        player.kickPlayer(ChatColor.RED + "You have been kicked by " + sender.getName() + "." + (reason != null ? ("\nReason: " + ChatColor.YELLOW + reason) : ""));
        
        return true;
    }
}
    

