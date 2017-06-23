package main;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public enum GM {

    CREATIVE,
    SURVIVAL,
    ADVENTURE,
    SPECTATOR;

    public static void changeGamemode(GM gamemode, Player p) {
        switch(gamemode) {
        case CREATIVE :
            p.setGameMode(GameMode.CREATIVE);
            p.sendMessage("§a[§bGameMode§a] " + ChatColor.GOLD + "your gamemode is changed to  " + ChatColor.AQUA + "Creative");
            break;
        case SURVIVAL :
            p.setGameMode(GameMode.SURVIVAL);
            p.sendMessage("§a[§bGameMode§a] " + ChatColor.GOLD + "your gamemode is changed to " + ChatColor.AQUA + "Survival");
            break;
        case ADVENTURE :
            p.setGameMode(GameMode.ADVENTURE);
            p.sendMessage("§a[§bGameMode§a] " + ChatColor.GOLD + "your gamemode is changed to " + ChatColor.AQUA + "Adventure");
            break;
        case SPECTATOR :
            p.setGameMode(GameMode.SPECTATOR);
            p.sendMessage("§a[§bGameMode§a] " + ChatColor.GOLD + "your gamemode is changed to " + ChatColor.AQUA + "Spectator");
            break;
        }
    }
}