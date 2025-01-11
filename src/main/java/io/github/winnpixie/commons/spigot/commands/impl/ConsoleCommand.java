package io.github.winnpixie.commons.spigot.commands.impl;

import io.github.winnpixie.commons.spigot.commands.BaseCommand;
import io.github.winnpixie.commons.spigot.commands.CommandErrors;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

public abstract class ConsoleCommand<P extends JavaPlugin> extends BaseCommand<P> {
    public ConsoleCommand(P plugin, String name) {
        super(plugin, name);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof ConsoleCommandSender console)) {
            sender.spigot().sendMessage(CommandErrors.CONSOLE_ONLY);
            return true;
        }

        return execute(console, command, label, args);
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        return sender instanceof ConsoleCommandSender console ? tabComplete(console, command, alias, args) : Collections.emptyList();
    }

    public abstract boolean execute(@NotNull ConsoleCommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args);

    @Nullable
    public List<String> tabComplete(@NotNull ConsoleCommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        return Collections.emptyList();
    }
}
