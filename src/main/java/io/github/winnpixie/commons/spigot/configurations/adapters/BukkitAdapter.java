package io.github.winnpixie.commons.spigot.configurations.adapters;

import io.github.winnpixie.commons.spigot.configurations.ConfigurationAdapter;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BukkitAdapter extends ConfigurationAdapter<ConfigurationSection> {
    @Override
    @Nullable
    public Object get(@NotNull String key, @Nullable Object defaultValue) {
        return getConfiguration().get(key, defaultValue);
    }

    @Override
    public void set(@NotNull String key, @Nullable Object value) {
        getConfiguration().set(key, value);
    }

    @Override
    public boolean has(@NotNull String key) {
        return getConfiguration().contains(key, false);
    }
}
