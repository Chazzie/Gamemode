package main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener {
  
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
    }
  
    @Override
        public boolean onCommand(CommandSender s, Command cmd, String CommandLabel, String[] args) {
        if (s instanceof Player) {
            Player p = (Player) s;
            if (cmd.getName().equalsIgnoreCase("gamemode") || cmd.getName().equalsIgnoreCase("gm")) {
                if (!p.hasPermission("gamemode.change.own")) {
                    s.sendMessage("§a[§bGameMode§a] " + ChatColor.RED + "you don't have permissions!");
                    return true;
                }
            }
            if (args.length == 0) {
                s.sendMessage("§a[§bGameMode§a] " + ChatColor.RED + "use /gm <0,1,2,3 > [player]");
                return true;
            }
            {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("c") || args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("crea")) {
                        GM.changeGamemode(GM.CREATIVE, p); 
                    }else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("a") || args[0].equalsIgnoreCase("adventure")) {
                        GM.changeGamemode(GM.ADVENTURE, p);
                    }else if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spec") || args[0].equalsIgnoreCase("sp") || args[0].equalsIgnoreCase("spectator")) {
                        GM.changeGamemode(GM.SPECTATOR, p);
                    }else if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("s") || args[0].equalsIgnoreCase("sur") || args[0].equalsIgnoreCase("survival")) {
                        GM.changeGamemode(GM.SURVIVAL, p);
                    }  
                }
            }
            if (args.length == 2) {
            	if (!p.hasPermission("gamemode.change.others")) {
            		s.sendMessage("§a[§bGameMode§a] " + ChatColor.RED + "you don't have permissions to change other players gamemode!");
            		return true;
            	}
                Player target = Bukkit.getServer().getPlayer(args[1]);
                   if (target == null) {
                       s.sendMessage("§a[§bGameMode§a] " + ChatColor.RED + "can't find that player!");
                       return true;
                   }
                   if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("c") || args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("crea")) {
                	   GM.changeGamemode(GM.CREATIVE, target); 
                   }else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("a") || args[0].equalsIgnoreCase("adventure")) {
                	   GM.changeGamemode(GM.ADVENTURE, target);
                   }else if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spec") || args[0].equalsIgnoreCase("sp") || args[0].equalsIgnoreCase("spectator")) {
                	   GM.changeGamemode(GM.SPECTATOR, target);
                   }else if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("s") || args[0].equalsIgnoreCase("sur") || args[0].equalsIgnoreCase("survival")) {
                	   GM.changeGamemode(GM.SURVIVAL, target);
                   }
                   s.sendMessage("§a[§bGameMode§a] " + ChatColor.AQUA + "you changed the gamemode of: " + ChatColor.RED + target.getDisplayName());
                   target.sendMessage("§a[§bGameMode§a] " + ChatColor.GOLD + "your gamemode is changed by " + ChatColor.RED + s.getName());
            }
        }
        return false;
    }
}