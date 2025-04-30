package io.github.winnpixie.commons.spigot.configurations.adapters;

import io.github.winnpixie.commons.spigot.configurations.ConfigurationAdapter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class MapAdapter extends ConfigurationAdapter<Map<Object, Object>> {
    @Override
    public @Nullable Object get(@NotNull String key, @Nullable Object defaultValue) {
        return getConfiguration().getOrDefault(key, defaultValue);
    }

    @Override
    public void set(@NotNull String key, @Nullable Object value) {
        getConfiguration().put(key, value);
    }

    @Override
    public boolean has(@NotNull String key) {
        return getConfiguration().containsKey(key);
    }
}
