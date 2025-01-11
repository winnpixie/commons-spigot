package io.github.winnpixie.commons.spigot.configurations.adapters;

import io.github.winnpixie.commons.spigot.configurations.IConfigurationAdapter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Properties;

public class PropertiesConfigurationAdapter implements IConfigurationAdapter<Properties> {
    private Properties properties;

    public PropertiesConfigurationAdapter(@Nullable Properties properties) {
        this.properties = properties;
    }

    @Override
    @Nullable
    public Properties getConfiguration() {
        return properties;
    }

    @Override
    public void setConfiguration(@Nullable Properties configuration) {
        this.properties = configuration;
    }

    @Override
    @Nullable
    public Object get(@NotNull String key, @NotNull Object def) {
        if (!(def instanceof String)) throw new IllegalArgumentException("Default value must be of type String");

        return properties.getProperty(key, (String) def);
    }

    @Override
    public void set(@NotNull String key, @NotNull Object value) {
        if (!(value instanceof String)) throw new IllegalArgumentException("Value must be of type String");

        properties.setProperty(key, (String) value);
    }
}
