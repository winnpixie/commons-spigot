package io.github.winnpixie.hukkit.configs.adapters;

import io.github.winnpixie.hukkit.configs.ConfigurationAdapter;

import java.util.Properties;

public class JavaAdapter implements ConfigurationAdapter {
    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public Object get(String key, Object def) {
        if (!(def instanceof String) && def != null)
            throw new IllegalArgumentException("Non-null default value must be of type String");

        return properties.getProperty(key, (String) def);
    }

    @Override
    public void set(String key, Object value) {
        if (!(value instanceof String) && value != null)
            throw new IllegalArgumentException("Non-null value must be of type String");

        properties.setProperty(key, (String) value);
    }
}
