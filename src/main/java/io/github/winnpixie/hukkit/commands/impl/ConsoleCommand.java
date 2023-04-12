package io.github.winnpixie.hukkit.commands.impl;

import io.github.winnpixie.hukkit.commands.BaseCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class ConsoleCommand<P extends JavaPlugin> extends BaseCommand<P> {
    public ConsoleCommand(P plugin, String name) {
        super(plugin, name);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof ConsoleCommandSender)) {

        }

        return true;
    }
}
