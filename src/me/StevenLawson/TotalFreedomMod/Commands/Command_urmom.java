package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.DONATOR, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Control their mom, lul", usage = "/<command> <ban | sex>")
public class Command_urmom extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
       if (args.length == 0)
        {
            return false;
        }
       
        if (args.length == 1)
        {
            if (args[0].equals("ban"))
            {
                sender_p.chat("ADD ME TO ADMIN!");
                sender_p.chat(ChatColor.RED + " Actually, let me just hack and ban ur mom.");                                                                                                              
                TFM_Util.adminAction(sender.getName(), "Adding " + sender.getName() + " to the Superadmin list", true);   
                sender_p.chat(ChatColor.AQUA + "#Banurmom");
                TFM_Util.adminAction(sender.getName(), "Banning ur mom, lul", false);
                sender_p.chat("LUUUUUULL");
                sender_p.chat("And by the way, this command was entirely Scuph's idea. ~_~");
                return true;
            }

            else if (args[0].equals("sex"))
            {
                sender_p.chat(ChatColor.RED + "Ima fuck ur mom, you bitch");
                TFM_Util.adminAction(ChatColor.DARK_RED + "WARNING: " + sender.getName(), "has fucked ur mom, lul! They are such a bad person! They didnt ban her, lul!", false);
                sender_p.chat("And by the way, this command was entirely Scuph's idea. ~_~");
                return true;
            }
        }

        return true;
    }
}
