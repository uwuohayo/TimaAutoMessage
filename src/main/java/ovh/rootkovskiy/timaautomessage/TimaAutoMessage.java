package ovh.rootkovskiy.timaautomessage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;
import java.util.Random;

public final class TimaAutoMessage extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        new BukkitRunnable() {
            @Override
            public void run() {

                int r = new Random().nextInt(getConfig().getConfigurationSection("messages").getKeys(false).size());
                List<String> selected = getConfig().getStringList("messages." + r);

                selected.forEach(s -> Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', s)));

            }
        }.runTaskTimer(this, 1, getConfig().getInt("interval") * 20L);

        getLogger().info("Plugin enabled");
        System.out.println(Console.ANSI_GREEN + "#-#-#-#-#-#-#-#-#" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "TimaAutoMessage " + getDescription().getVersion() + " Loaded and Enabled!" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "MC Version: " + getServer().getBukkitVersion() + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "Author: Timur Rootkovskiy (Adminov)" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "VK: @timurroot" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_GREEN + "#-#-#-#-#-#-#-#-#" + Console.ANSI_RESET);
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled");
        System.out.println(Console.ANSI_GREEN + "#-#-#-#-#-#-#-#-#" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "TimaAutoMessage " + getDescription().getVersion() + " Disabled!" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "MC Version: " + getServer().getBukkitVersion() + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "Author: Timur Rootkovskiy (Adminov)" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "VK: @timurroot" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_CYAN + "Goodbye ;p" + Console.ANSI_RESET);
        System.out.println(Console.ANSI_GREEN + "#-#-#-#-#-#-#-#-#" + Console.ANSI_RESET);
    }
}
