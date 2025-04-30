package io.github.winnpixie.commons.spigot.configurations.adapters;

import io.github.winnpixie.commons.spigot.configurations.ConfigurationAdapter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Properties;

public class PropertiesAdapter extends ConfigurationAdapter<Properties> {
    @Override
    @Nullable
    public Object get(@NotNull String key, @Nullable Object defaultValue) {
        if (!(defaultValue instanceof String strVal))
            throw new IllegalArgumentException("Default value must be of type String");

        return getConfiguration().getProperty(key, strVal);
    }

    @Override
    public void set(@NotNull String key, @Nullable Object value) {
        if (!(value instanceof String strVal)) throw new IllegalArgumentException("Value must be of type String");

        getConfiguration().setProperty(key, strVal);
    }

    @Override
    public boolean has(@NotNull String key) {
        return getConfiguration().containsKey(key);
    }
}
