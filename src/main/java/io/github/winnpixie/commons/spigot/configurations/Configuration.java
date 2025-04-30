package io.github.winnpixie.commons.spigot.configurations;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class Configuration {
    private ConfigurationAdapter<?> configurationAdapter;

    /**
     * Constructs an instance of {@link Configuration} without an {@link ConfigurationAdapter}.
     */
    public Configuration() {
    }

    /**
     * Constructs an instance of {@link Configuration} with an underlying {@link ConfigurationAdapter}.
     *
     * @param configurationAdapter The {@link ConfigurationAdapter} to use.
     */
    public Configuration(@Nullable ConfigurationAdapter<?> configurationAdapter) {
        this.configurationAdapter = configurationAdapter;
    }

    /**
     * @return The underlying {@link ConfigurationAdapter} being used.
     */
    @Nullable
    public ConfigurationAdapter<?> getConfigurationAdapter() {
        return configurationAdapter;
    }

    /**
     * Set the underlying {@link ConfigurationAdapter} for this instance.
     *
     * @param configurationAdapter The {@link ConfigurationAdapter} to use.
     */
    public void setAdapter(@NotNull ConfigurationAdapter<?> configurationAdapter) {
        this.configurationAdapter = configurationAdapter;
    }

    public void load() {
    }

    public void save() {
    }
}
