package io.github.winnpixie.hukkit.configs.adapters;

import io.github.winnpixie.hukkit.configs.ConfigurationAdapter;
import org.bukkit.configuration.ConfigurationSection;

public class BukkitAdapter implements ConfigurationAdapter {
    private ConfigurationSection bukkitConfig;

    public ConfigurationSection getBukkitConfig() {
        return bukkitConfig;
    }

    public void setBukkitConfig(ConfigurationSection bukkitConfig) {
        this.bukkitConfig = bukkitConfig;
    }

    @Override
    public Object get(String key, Object def) {
        return bukkitConfig.get(key, def);
    }

    @Override
    public void set(String key, Object value) {
        bukkitConfig.set(key, value);
    }
}
