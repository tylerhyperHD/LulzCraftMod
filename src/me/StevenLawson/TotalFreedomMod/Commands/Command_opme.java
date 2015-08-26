package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_PlayerData;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Automatically ops user.", usage = "/<command>")
public class Command_opme extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        TFM_PlayerData playerData = TFM_PlayerData.getPlayerData((Player) sender);
        if (playerData.isSmited())
        {
            playerMsg(ChatColor.RED + "Sorry, but you were smited just recently and you must be opped by an admin.");
            return true;
        }
        TFM_Util.bcastMsg(sender.getName() + " has given themself op.", ChatColor.BLUE);
        sender.setOp(true);
        sender.sendMessage(TFM_Command.YOU_ARE_OP);

        return true;
    }
}
