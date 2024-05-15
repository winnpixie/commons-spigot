package io.github.winnpixie.commons.spigot.listeners;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class EventListener<P extends JavaPlugin> implements Listener {
    private final P plugin;

    public EventListener(P plugin) {
        this.plugin = plugin;
    }

    public P getPlugin() {
        return plugin;
    }
}
