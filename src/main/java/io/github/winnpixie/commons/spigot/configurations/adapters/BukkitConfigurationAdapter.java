package io.github.winnpixie.commons.spigot.configurations.adapters;

import io.github.winnpixie.commons.spigot.configurations.IConfigurationAdapter;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BukkitConfigurationAdapter implements IConfigurationAdapter<ConfigurationSection> {
    private ConfigurationSection configSection;

    public BukkitConfigurationAdapter(@Nullable ConfigurationSection configSection) {
        this.configSection = configSection;
    }

    @Override
    @Nullable
    public ConfigurationSection getConfiguration() {
        return configSection;
    }

    @Override
    public void setConfiguration(@Nullable ConfigurationSection configuration) {
        this.configSection = configuration;
    }

    @Override
    @Nullable
    public Object get(@NotNull String key, @Nullable Object def) {
        return configSection.get(key, def);
    }

    @Override
    public void set(@NotNull String key, @Nullable Object value) {
        configSection.set(key, value);
    }
}
