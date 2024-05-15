package io.github.winnpixie.commons.spigot.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class BaseCommand<P extends JavaPlugin> implements TabExecutor {
    private final P plugin;
    private final String name;

    public BaseCommand(P plugin, String name) {
        this.plugin = plugin;
        this.name = name;
    }

    public P getPlugin() {
        return plugin;
    }

    public String getName() {
        return name;
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        return null;
    }
}
