package io.github.winnpixie.hukkit.commands.impl;

import io.github.winnpixie.hukkit.commands.BaseCommand;
import io.github.winnpixie.hukkit.commands.CommandErrors;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public abstract class PlayerCommand<P extends JavaPlugin> extends BaseCommand<P> {
    public PlayerCommand(P plugin, String name) {
        super(plugin, name);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.spigot().sendMessage(CommandErrors.PLAYERS_ONLY);

            return true;
        }

        return execute((Player) sender, command, label, args);
    }

    public abstract boolean execute(@NotNull Player sender, @NotNull Command command, @NotNull String label, @NotNull String[] args);
}
