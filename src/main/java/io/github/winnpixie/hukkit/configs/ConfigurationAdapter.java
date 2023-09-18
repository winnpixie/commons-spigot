package io.github.winnpixie.hukkit.configs;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ConfigurationAdapter {
    @Nullable
    default Object get(@NotNull String key) {
        return get(key, null);
    }

    @Nullable
    Object get(@NotNull String key, @Nullable Object def);

    void set(@NotNull String key, @Nullable Object value);
}
