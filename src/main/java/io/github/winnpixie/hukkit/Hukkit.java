package io.github.winnpixie.hukkit;

import io.github.winnpixie.hukkit.commands.BaseCommand;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Hukkit {
    public static void addListener(Listener listener, JavaPlugin owner) {
        owner.getServer().getPluginManager().registerEvents(listener, owner);
    }

    public static <P extends JavaPlugin> boolean addCommand(BaseCommand<P> hCommand, P owner) {
        var pluginCmd = owner.getCommand(hCommand.getName());
        if (pluginCmd == null) return false; // Not registered in plugin.yml ?

        pluginCmd.setExecutor(hCommand);
        pluginCmd.setTabCompleter(hCommand);
        return true;
    }
}
