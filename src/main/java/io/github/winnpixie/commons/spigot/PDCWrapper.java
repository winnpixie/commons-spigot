package io.github.winnpixie.commons.spigot;

import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class PDCWrapper<P extends JavaPlugin> {
    private static final Map<String, NamespacedKey> KEY_CACHE = new HashMap<>();

    private final PersistentDataContainer container;
    private final P plugin;

    public PDCWrapper(PersistentDataContainer container, P plugin) {
        this.container = container;
        this.plugin = plugin;
    }

    @Nullable
    public <T, V> V get(String key, PersistentDataType<T, V> type) {
        return container.get(getKeyByName(key), type);
    }

    @NotNull
    public <T, V> V get(String key, PersistentDataType<T, V> type, V fallback) {
        return container.getOrDefault(getKeyByName(key), type, fallback);
    }

    public byte getByte(String key) {
        return get(key, Type.BYTE);
    }

    public byte getByte(String key, byte defaultValue) {
        return get(key, Type.BYTE, defaultValue);
    }

    public short getShort(String key) {
        return get(key, Type.SHORT);
    }

    public short getShort(String key, short defaultValue) {
        return get(key, Type.SHORT, defaultValue);
    }

    public int getInt(String key) {
        return get(key, Type.INTEGER);
    }

    public int getInt(String key, int defaultValue) {
        return get(key, Type.INTEGER, defaultValue);
    }

    public long getLong(String key) {
        return get(key, Type.BYTE);
    }

    public long getLong(String key, long defaultValue) {
        return get(key, Type.LONG, defaultValue);
    }

    public float getFloat(String key) {
        return get(key, Type.SHORT);
    }

    public float getFloat(String key, float defaultValue) {
        return get(key, Type.FLOAT, defaultValue);
    }

    public double getDouble(String key) {
        return get(key, Type.INTEGER);
    }

    public double getDouble(String key, double defaultValue) {
        return get(key, Type.DOUBLE, defaultValue);
    }

    @Nullable
    public String getString(String key) {
        return get(key, Type.STRING);
    }

    public boolean getBoolean(String key) {
        return get(key, Type.BOOLEAN);
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return get(key, Type.BOOLEAN, defaultValue);
    }

    @NotNull
    public String getString(String key, String defaultValue) {
        return get(key, Type.STRING, defaultValue);
    }

    public byte[] getByteArray(String key) {
        return get(key, Type.BYTE_ARRAY);
    }

    public byte[] getByteArray(String key, byte[] defaultValue) {
        return get(key, Type.BYTE_ARRAY, defaultValue);
    }

    public int[] getIntArray(String key) {
        return get(key, Type.INTEGER_ARRAY);
    }

    public int[] getIntArray(String key, int[] defaultValue) {
        return get(key, Type.INTEGER_ARRAY, defaultValue);
    }

    public long[] getLongArray(String key) {
        return get(key, Type.LONG_ARRAY);
    }

    public long[] getLongArray(String key, long[] defaultValue) {
        return get(key, Type.LONG_ARRAY, defaultValue);
    }

    public float[] getFloatArray(String key) {
        return get(key, Type.FLOAT_ARRAY);
    }

    public float[] getFloatArray(String key, float[] defaultValue) {
        return get(key, Type.FLOAT_ARRAY, defaultValue);
    }

    public double[] getDoubleArray(String key) {
        return get(key, Type.DOUBLE_ARRAY);
    }

    public double[] getDoubleArray(String key, double[] defaultValue) {
        return get(key, Type.DOUBLE_ARRAY, defaultValue);
    }

    public <T, V> void set(String key, PersistentDataType<T, V> type, V value) {
        container.set(getKeyByName(key), type, value);
    }

    public void setByte(String key, byte value) {
        set(key, Type.BYTE, value);
    }

    public void setShort(String key, short value) {
        set(key, Type.SHORT, value);
    }

    public void setInt(String key, int value) {
        set(key, Type.INTEGER, value);
    }

    public void setLong(String key, long value) {
        set(key, Type.LONG, value);
    }

    public void setFloat(String key, float value) {
        set(key, Type.FLOAT, value);
    }

    public void setDouble(String key, double value) {
        set(key, Type.DOUBLE, value);
    }

    public void setString(String key, String value) {
        set(key, Type.STRING, value);
    }

    public void setBoolean(String key, boolean value) {
        set(key, Type.BOOLEAN, value);
    }

    public void setByteArray(String key, byte[] value) {
        set(key, Type.BYTE_ARRAY, value);
    }

    public void setIntArray(String key, int[] value) {
        set(key, Type.INTEGER_ARRAY, value);
    }

    public void setLongArray(String key, long[] value) {
        set(key, Type.LONG_ARRAY, value);
    }

    public void setFloatArray(String key, float[] value) {
        set(key, Type.FLOAT_ARRAY, value);
    }

    public void setDoubleArray(String key, double[] value) {
        set(key, Type.DOUBLE_ARRAY, value);
    }

    public boolean has(String key) {
        NamespacedKey realKey = getKeyByName(key);

        for (NamespacedKey keyEntry : container.getKeys()) {
            if (!keyEntry.equals(realKey)) continue;

            return true;
        }

        return false;
    }

    public <T, V> boolean has(String key, PersistentDataType<T, V> type) {
        return container.has(getKeyByName(key), type);
    }

    public void remove(String key) {
        container.remove(getKeyByName(key));
        KEY_CACHE.remove(key);
    }

    @NotNull
    private NamespacedKey getKeyByName(String key) {
        return KEY_CACHE.computeIfAbsent(key, v -> new NamespacedKey(plugin, key));
    }

    public interface Type<T, V> extends PersistentDataType<T, V> {
        PersistentDataType<Byte, Boolean> BOOLEAN = new PersistentDataType<Byte, Boolean>() {
            @NotNull
            @Override
            public Class<Byte> getPrimitiveType() {
                return Byte.class;
            }

            @NotNull
            @Override
            public Class<Boolean> getComplexType() {
                return Boolean.class;
            }

            @NotNull
            @Override
            public Byte toPrimitive(@NotNull Boolean complex, @NotNull PersistentDataAdapterContext context) {
                return complex ? (byte) 1 : (byte) 0;
            }

            @NotNull
            @Override
            public Boolean fromPrimitive(@NotNull Byte primitive, @NotNull PersistentDataAdapterContext context) {
                return primitive == 1;
            }
        };
        PersistentDataType<float[], float[]> FLOAT_ARRAY = new PersistentDataType<float[], float[]>() {
            @NotNull
            @Override
            public Class<float[]> getPrimitiveType() {
                return float[].class;
            }

            @NotNull
            @Override
            public Class<float[]> getComplexType() {
                return float[].class;
            }

            @NotNull
            @Override
            public float[] toPrimitive(@NotNull float[] complex, @NotNull PersistentDataAdapterContext context) {
                return complex;
            }

            @NotNull
            @Override
            public float[] fromPrimitive(@NotNull float[] primitive, @NotNull PersistentDataAdapterContext context) {
                return primitive;
            }
        };
        PersistentDataType<double[], double[]> DOUBLE_ARRAY = new PersistentDataType<double[], double[]>() {
            @NotNull
            @Override
            public Class<double[]> getPrimitiveType() {
                return double[].class;
            }

            @NotNull
            @Override
            public Class<double[]> getComplexType() {
                return double[].class;
            }

            @NotNull
            @Override
            public double[] toPrimitive(double[] complex, PersistentDataAdapterContext context) {
                return complex;
            }

            @NotNull
            @Override
            public double[] fromPrimitive(@NotNull double[] primitive, @NotNull PersistentDataAdapterContext context) {
                return primitive;
            }
        };
    }
}
