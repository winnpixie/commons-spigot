package io.github.winnpixie.commons.spigot.commands.impl;

import io.github.winnpixie.commons.spigot.commands.BaseCommand;
import io.github.winnpixie.commons.spigot.commands.CommandErrors;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

public abstract class PlayerCommand<P extends JavaPlugin> extends BaseCommand<P> {
    public PlayerCommand(P plugin, String name) {
        super(plugin, name);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            sender.spigot().sendMessage(CommandErrors.PLAYERS_ONLY);
            return true;
        }

        return execute(player, command, label, args);
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        return sender instanceof Player player ? tabComplete(player, command, alias, args) : Collections.emptyList();
    }

    public abstract boolean execute(@NotNull Player sender, @NotNull Command command, @NotNull String label, @NotNull String[] args);

    @Nullable
    public List<String> tabComplete(@NotNull Player sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        return Collections.emptyList();
    }
}
