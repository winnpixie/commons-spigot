package io.github.winnpixie.hukkit.configs.adapters;

import io.github.winnpixie.hukkit.configs.ConfigurationAdapter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Properties;

public class JavaAdapter implements ConfigurationAdapter {
    private Properties properties;

    public JavaAdapter(Properties properties) {
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
    public Object get(@NotNull String key, @Nullable Object def) {
        if (!(def instanceof String) && def != null)
            throw new IllegalArgumentException("Non-null default value must be of type String");

        return properties.getProperty(key, (String) def);
    }

    @Override
    public void set(@NotNull String key, @Nullable Object value) {
        if (!(value instanceof String) && value != null)
            throw new IllegalArgumentException("Non-null value must be of type String");

        properties.setProperty(key, (String) value);
    }
}
