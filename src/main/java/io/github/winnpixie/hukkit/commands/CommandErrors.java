package io.github.winnpixie.hukkit.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;

public class CommandErrors {
    public static final BaseComponent[] INVALID_TARGET = new ComponentBuilder("Unable to locate the specified target.")
            .color(ChatColor.RED)
            .create();
    public static final BaseComponent[] PLAYERS_ONLY = new ComponentBuilder("This action is only available for players.")
            .color(ChatColor.RED)
            .create();
    public static final BaseComponent[] CONSOLE_ONLY = new ComponentBuilder("This action is only available for the console.")
            .color(ChatColor.RED)
            .create();
    public static final BaseComponent[] MISSING_ARGUMENTS = new ComponentBuilder("Missing necessary arguments to execute action.")
            .color(ChatColor.RED)
            .create();
    public static final BaseComponent[] INVALID_ARGUMENTS = new ComponentBuilder("Invalid argument(s) provided for action.")
            .color(ChatColor.RED)
            .create();
    public static final BaseComponent[] LACKS_PERMISSIONS = new ComponentBuilder("Missing required permission(s) to execute action.")
            .color(ChatColor.RED)
            .create();
}