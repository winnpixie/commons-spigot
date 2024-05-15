package io.github.winnpixie.commons.spigot.configs.adapters;

import io.github.winnpixie.commons.spigot.configs.IAdapter;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BukkitAdapter implements IAdapter {
    private ConfigurationSection config;

    public BukkitAdapter(ConfigurationSection config) {
        this.config = config;
    }

    public ConfigurationSection getConfig() {
        return config;
    }

    public void setConfig(ConfigurationSection config) {
        this.config = config;
    }

    @Override
    @Nullable
    public Object get(@NotNull String key, @Nullable Object def) {
        return config.get(key, def);
    }

    @Override
    public void set(@NotNull String key, @Nullable Object value) {
        config.set(key, value);
    }
}
