//This is kieran3810's System Administrator Management Command
//He deserves credit since it his plugin
//DaPhoenix says that she couldn't code one because she had to go do homework after this.


package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(
        description = "A command for system admins only",
        usage = "/<command> [add <player> | del <player> | teston | testoff]")
public class Command_sys extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole){
    	
    
         if (!TFM_Util.SYSADMINS.contains(sender.getName()) || TFM_AdminList.isAdminImpostor((Player) sender))
        {
            playerMsg(ChatColor.YELLOW + "You do not have permission to use this command.");
            TFM_Util.bcastMsg("WARNING: " + sender.getName() + " has attempted to use an executive only command!", ChatColor.RED);
            return true;
        } 
        if (args.length == 0)
        {
            return false;
        }

        String mode = args[0].toLowerCase();

        if (mode.equals("add"))
        {
        	Player player = getPlayer(args[1]);
        	if (player == null){
        		sender.sendMessage(ChatColor.GRAY + "Player not found.");
        	}
        	TFM_Util.adminAction(sender.getName(), "Adding " + args[1] + " to the superadmin list", true);
        	TFM_AdminList.addSuperadmin(player);
        }
        
        if (mode.equals("del"))
        {
        	Player player = getPlayer(args[1]);
        	if (player == null){
        		sender.sendMessage(ChatColor.GRAY + "Player not found.");
        	}
        	TFM_Util.adminAction(sender.getName(), "Deleting user: " + args[1] + " from the superadmin list", true);
        	TFM_AdminList.removeSuperadmin(player);
        }
        
        if (mode.equals("teston"))
        {
        	TFM_Util.bcastMsg(ChatColor.RED + "WARNING: " + sender.getName() + " has started testing on this server.");
        }
        
        if (mode.equals("testoff"))
        {
        	TFM_Util.bcastMsg(ChatColor.RED + sender.getName() + " has successfully finished testing on this server.");
        }
        
        return true;
    }  
}
