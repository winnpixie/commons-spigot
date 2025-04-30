package io.github.winnpixie.commons.spigot.configurations;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * An adapter to stream-line the process of getting/setting key-values for an underlying configuration provider
 *
 * @param <T> The underlying configuration provider type.
 */
public abstract class ConfigurationAdapter<T> {
    private T configuration;

    public ConfigurationAdapter() {
    }

    public ConfigurationAdapter(T configuration) {
        this.configuration = configuration;
    }

    @Nullable
    public T getConfiguration() {
        return configuration;
    }

    public void setConfiguration(@NotNull T configuration) {
        this.configuration = configuration;
    }

    @Nullable
    public Object get(@NotNull String key) {
        return get(key, null);
    }

    @Nullable
    public abstract Object get(@NotNull String key, @Nullable Object defaultValue);

    public abstract void set(@NotNull String key, @Nullable Object value);

    public boolean has(@NotNull String key) {
        return false;
    }
}
