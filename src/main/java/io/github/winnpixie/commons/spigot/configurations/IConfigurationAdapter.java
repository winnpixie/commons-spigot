package io.github.winnpixie.commons.spigot.configurations;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface IConfigurationAdapter<T> {
    @Nullable
    T getConfiguration();

    void setConfiguration(@Nullable T configuration);

    @Nullable
    default Object get(@NotNull String key) {
        return get(key, null);
    }

    @Nullable
    Object get(@NotNull String key, @Nullable Object def);

    void set(@NotNull String key, @Nullable Object value);
}
