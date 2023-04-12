package io.github.winnpixie.hukkit.configs.adapters;

import io.github.winnpixie.hukkit.configs.ConfigurationAdapter;
import org.bukkit.configuration.ConfigurationSection;

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
    public Object get(String key, Object def) {
        return config.get(key, def);
    }

    @Override
    public void set(String key, Object value) {
        config.set(key, value);
    }
}
