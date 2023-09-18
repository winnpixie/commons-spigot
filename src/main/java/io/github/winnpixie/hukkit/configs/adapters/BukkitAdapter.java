package io.github.winnpixie.hukkit.configs.adapters;

import io.github.winnpixie.hukkit.configs.ConfigurationAdapter;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BukkitAdapter implements ConfigurationAdapter {
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
