package io.github.winnpixie.commons.spigot;

import io.github.winnpixie.commons.spigot.commands.BaseCommand;
import io.github.winnpixie.commons.spigot.listeners.EventListener;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Optional;
import java.util.UUID;

public class SpigotHelper {
    public static <P extends JavaPlugin> void addListener(Listener listener, P owner) {
        owner.getServer().getPluginManager().registerEvents(listener, owner);
    }

    public static <P extends JavaPlugin> void addListener(EventListener<P> listener) {
        addListener(listener, listener.getPlugin());
    }

    public static <P extends JavaPlugin> boolean addCommand(BaseCommand<P> command) {
        PluginCommand pluginCmd = command.getPlugin().getCommand(command.getName());
        if (pluginCmd == null) return false; // Not registered in plugin.yml ?

        pluginCmd.setExecutor(command);
        pluginCmd.setTabCompleter(command);
        return true;
    }

    public static Optional<Entity> findEntity(UUID id) {
        return Optional.ofNullable(Bukkit.getEntity(id));
    }

    public static Optional<Player> findPlayer(String username) {
        return Optional.ofNullable(Bukkit.getPlayer(username));
    }

    public static Optional<Player> findPlayerExact(String username) {
        return Optional.ofNullable(Bukkit.getPlayerExact(username));
    }

    public static Optional<Player> findPlayer(UUID id) {
        return Optional.ofNullable(Bukkit.getPlayer(id));
    }

    @Deprecated
    public static Optional<OfflinePlayer> getOfflinePlayer(String username) {
        return Optional.of(Bukkit.getOfflinePlayer(username));
    }

    public static Optional<OfflinePlayer> getOfflinePlayer(UUID id) {
        return Optional.of(Bukkit.getOfflinePlayer(id));
    }

    public static Optional<World> findWorld(String name) {
        return Optional.ofNullable(Bukkit.getWorld(name));
    }

    public static Optional<World> findWorld(UUID id) {
        return Optional.ofNullable(Bukkit.getWorld(id));
    }
}
