package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "I hate doing stuff I'm dared to do... ~_~", usage = "/<command> [playername] [playername]")
public class Command_ship extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length != 2)
        {
            playerMsg(ChatColor.RED + "Invalid player.");            
            return true;
            
        }
      Player shipperProbablyMiddie = (Player)sender;
      Player p1 = getPlayer(args[0]);
      Player p2 = getPlayer(args[1]);

      if ((p1 == null) || (!p1.isOnline()) || (p2 == null) || (!p2.isOnline())) {
        playerMsg(ChatColor.RED + "Invalid player.");
        return true;
      }
      
      if ((p1 == p2) && (p1.getName().equalsIgnoreCase(sender.getName())) || (p1 == p2) && (p2.getName().equalsIgnoreCase(sender.getName())))
      {
        sender.sendMessage(ChatColor.RED + "For some unknown reason, you just tried to ship yourself with yourself. Seriously? I don't believe it! I" + ChatColor.ITALIC + " really don't" + ChatColor.RESET + ChatColor.RED + "! Why you did, we'll never know, but one thing we do know is that you love yourself so much and that you're pretty stupid. Here, have a cookie.");
            final ItemStack heldItem = new ItemStack(Material.COOKIE);
            final ItemMeta heldItemMeta = heldItem.getItemMeta();
            heldItemMeta.setDisplayName((new StringBuilder()).append(ChatColor.WHITE).append("Idiot of ").append(ChatColor.DARK_GRAY).append("the week ").append(ChatColor.WHITE).append("award").toString());
            heldItem.setItemMeta(heldItemMeta);
            final int firstEmpty = shipperProbablyMiddie.getInventory().firstEmpty();
            shipperProbablyMiddie.getInventory().setItem(firstEmpty, heldItem);
        return true;
      }
      
      if (p1 == p2)
      {
        sender.sendMessage(ChatColor.RED + "For some unknown reason, you just tried to ship the same person with themself. Seriously? I don't believe it! I" + ChatColor.ITALIC + " really don't" + ChatColor.RESET + ChatColor.RED + "! Why you did, we'll never know, but one thing we do know is that you love yourself so much and that you're pretty stupid. Here, have a cookie.");
            final ItemStack heldItem = new ItemStack(Material.COOKIE);
            final ItemMeta heldItemMeta = heldItem.getItemMeta();
            heldItemMeta.setDisplayName((new StringBuilder()).append(ChatColor.WHITE).append("Idiot of ").append(ChatColor.DARK_GRAY).append("the week ").append(ChatColor.WHITE).append("award").toString());
            heldItem.setItemMeta(heldItemMeta);
            final int firstEmpty = shipperProbablyMiddie.getInventory().firstEmpty();
            shipperProbablyMiddie.getInventory().setItem(firstEmpty, heldItem);
        return true;
      }
      
      if ((p1.getName().equalsIgnoreCase("ImALuckyGuy")) && (p2.getName().equalsIgnoreCase("neroblackcat")))
      {
        final ItemStack heldItem = new ItemStack(Material.COOKIE);
        final ItemMeta heldItemMeta = heldItem.getItemMeta();
        heldItemMeta.setDisplayName((new StringBuilder()).append(ChatColor.RED).append("Cookie for trying.").append(ChatColor.LIGHT_PURPLE).append(" <3").toString());
        heldItem.setItemMeta(heldItemMeta);
        final int firstEmpty = shipperProbablyMiddie.getInventory().firstEmpty();
        shipperProbablyMiddie.getInventory().setItem(firstEmpty, heldItem);
        shipperProbablyMiddie.kickPlayer(ChatColor.RED + "STOP RIGHT THERE, CRIMINAL SCUM." + ChatColor.WHITE + "\nIn your dreams, " + shipperProbablyMiddie.getName() + ". :D");
        return true;
      }
      if ((p1.getName().equalsIgnoreCase("neroblackcat")) && (p2.getName().equalsIgnoreCase("ImALuckyGuy")))
      {
        final ItemStack heldItem = new ItemStack(Material.COOKIE);
        final ItemMeta heldItemMeta = heldItem.getItemMeta();
        heldItemMeta.setDisplayName((new StringBuilder()).append(ChatColor.RED).append("Cookie for trying.").append(ChatColor.LIGHT_PURPLE).append(" <3").toString());
        heldItem.setItemMeta(heldItemMeta);
        final int firstEmpty = shipperProbablyMiddie.getInventory().firstEmpty();
        shipperProbablyMiddie.getInventory().setItem(firstEmpty, heldItem);
        shipperProbablyMiddie.kickPlayer(ChatColor.RED + "STOP RIGHT THERE, CRIMINAL SCUM." + ChatColor.WHITE + "\nIn your dreams, " + shipperProbablyMiddie.getName() + ". :D");
        return true;
      }
      else
      TFM_Util.bcastMsg(ChatColor.GREEN + "" + shipperProbablyMiddie.getName() + " ships " + p1.getName() + " x " + p2.getName() + "." + ChatColor.LIGHT_PURPLE + " <3");
          
      return true;
    }
    
}