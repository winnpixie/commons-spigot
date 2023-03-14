package io.github.winnpixie.hukkit.configs;

public interface ConfigurationAdapter {
    default Object get(String key) {
        return get(key, null);
    }

    Object get(String key, Object def);

    void set(String key, Object value);
}
