package io.github.winnpixie.commons.spigot.configs.adapters;

import io.github.winnpixie.commons.spigot.configs.IAdapter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Properties;

public class PropertiesAdapter implements IAdapter {
    private Properties properties;

    public PropertiesAdapter(Properties properties) {
        this.properties = properties;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
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
