package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.World.TFM_DonatorWorld;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.DONATOR, source = SourceType.BOTH)
@CommandParameters(description = "Go to the DonatorWorld.", usage = "/<command> [time <morning | noon | evening | night> | weather <off | on | storm>]")
public class Command_donatorworld extends TFM_Command
{
    private enum CommandMode
    {
        TELEPORT, TIME, WEATHER;
    }

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        CommandMode commandMode = null;

        if (args.length == 0)
        {
            commandMode = CommandMode.TELEPORT;
        }
        else if (args.length >= 2)
        {
            if ("time".equalsIgnoreCase(args[0]))
            {
                commandMode = CommandMode.TIME;
            }
            else if ("weather".equalsIgnoreCase(args[0]))
            {
                commandMode = CommandMode.WEATHER;
            }
        }

        if (commandMode == null)
        {
            return false;
        }

        try
        {
            switch (commandMode)
            {
                case TELEPORT:
                {
                    if (!(sender instanceof Player) || sender_p == null)
                    {
                        return true;
                    }

                    World DonatorWorld = null;
                    try
                    {
                        DonatorWorld = TFM_DonatorWorld.getInstance().getWorld();
                    }
                    catch (Exception ex)
                    {
                    }

                    if (DonatorWorld == null || sender_p.getWorld() == DonatorWorld)
                    {
                        playerMsg("Going to the main world.");
                        sender_p.teleport(server.getWorlds().get(0).getSpawnLocation());
                    }
                    else
                    {
                        if (TFM_DonatorWorld.getInstance().canAccessWorld(sender_p))
                        {
                            playerMsg("Going to the DonatorWorld.");
                            TFM_DonatorWorld.getInstance().sendToWorld(sender_p);
                        }
                        else
                        {
                            playerMsg("You don't have permission to access the DonatorWorld.");
                        }
                    }

                    break;
                }
                case TIME:
                {
                    assertCommandPerms(sender, sender_p);

                    if (args.length == 2)
                    {
                        TFM_DonatorWorld.TimeOfDay timeOfDay = TFM_DonatorWorld.TimeOfDay.getByAlias(args[1]);
                        if (timeOfDay != null)
                        {
                            TFM_DonatorWorld.getInstance().setTimeOfDay(timeOfDay);
                            playerMsg("DonatorWorld time set to: " + timeOfDay.name());
                        }
                        else
                        {
                            playerMsg("Invalid time of day. Can be: sunrise, noon, sunset, midnight");
                        }
                    }
                    else
                    {
                        return false;
                    }

                    break;
                }
                case WEATHER:
                {
                    assertCommandPerms(sender, sender_p);

                    if (args.length == 2)
                    {
                        TFM_DonatorWorld.WeatherMode weatherMode = TFM_DonatorWorld.WeatherMode.getByAlias(args[1]);
                        if (weatherMode != null)
                        {
                            TFM_DonatorWorld.getInstance().setWeatherMode(weatherMode);
                            playerMsg("DonatorWorld weather set to: " + weatherMode.name());
                        }
                        else
                        {
                            playerMsg("Invalid weather mode. Can be: off, rain, storm");
                        }
                    }
                    else
                    {
                        return false;
                    }

                    break;
                }
                default:
                {
                    return false;
                }
            }
        }
        catch (PermissionDeniedException ex)
        {
            sender.sendMessage(ex.getMessage());
        }

        return true;
    }

    private void assertCommandPerms(CommandSender sender, Player sender_p) throws PermissionDeniedException
    {
        if (!(sender instanceof Player) || sender_p == null || !TFM_AdminList.isSuperAdmin(sender))
        {
            throw new PermissionDeniedException(TFM_Command.MSG_NO_PERMS);
        }
    }

    private class PermissionDeniedException extends Exception
    {
        private static final long serialVersionUID = 1L;

        private PermissionDeniedException(String string)
        {
            super(string);
        }
    }
}
