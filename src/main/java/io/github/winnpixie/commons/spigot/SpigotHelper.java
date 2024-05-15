package io.github.winnpixie.commons.spigot;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import io.github.winnpixie.commons.spigot.commands.BaseCommand;
import io.github.winnpixie.commons.spigot.io.http.HttpClient;
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
import java.util.function.BiConsumer;

public class SpigotHelper {
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static <P extends JavaPlugin> void addListener(Listener listener, P owner) {
        owner.getServer().getPluginManager().registerEvents(listener, owner);
    }

    public static <P extends JavaPlugin> void addListener(EventListener<P> listener) {
        addListener(listener, listener.getPlugin());
    }

    public static <P extends JavaPlugin> boolean addCommand(BaseCommand<P> hCommand) {
        PluginCommand pluginCmd = hCommand.getPlugin().getCommand(hCommand.getName());
        if (pluginCmd == null) return false; // Not registered in plugin.yml ?

        pluginCmd.setExecutor(hCommand);
        pluginCmd.setTabCompleter(hCommand);
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

    public static void checkForUpdate(int resourceId, String version, BiConsumer<String, Boolean> onCheck) {
        HttpClient client = HttpClient.newClient();

        client.setUrl(String.format("https://api.spigotmc.org/simple/0.2/index.php?action=getResource&id=%d", resourceId))
                .onSuccess(response -> {
                    JsonObject jsonObj = GSON.fromJson(response.getBodyAsString(), JsonObject.class);
                    if (!jsonObj.has("current_version")) return;

                    String currentVersion = jsonObj.get("current_version").getAsString();
                    onCheck.accept(currentVersion, currentVersion.equals(version));
                }).onFailure(response -> onCheck.accept("", false))
                .send();
    }
}
