package io.github.winnpixie.hukkit.configs;

import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * An API for the Bukkit API that allows configuration values supplied via a
 * {@link ConfigurationAdapter} to be quickly and easily accessed through
 * standard Java fields linked by the {@link Link} annotation.
 *
 * @author Hannah
 * @since 0.0.1
 */
public class AnnotatedConfigurationManager {
    private ConfigurationAdapter adapter;

    private final List<WrappedField> wrappedFields = new ArrayList<>(); // or CopyOnWriteArrayList, concurrency go brrrr

    public AnnotatedConfigurationManager() {
    }

    /**
     * Constructs an AnnotatedConfigurationManager with a pre-defined
     * {@link ConfigurationSection}
     *
     * @param adapter
     */
    public AnnotatedConfigurationManager(@NotNull ConfigurationAdapter adapter) {
        this.adapter = adapter;
    }

    /**
     * @return The current {@link ConfigurationSection} this instance loaded from
     */
    @Nullable
    public ConfigurationAdapter getAdapter() {
        return adapter;
    }

    public AnnotatedConfigurationManager setAdapter(@NotNull ConfigurationAdapter adapter) {
        this.adapter = adapter;
        return this;
    }

    @NotNull
    public List<WrappedField> getWrappedFields() {
        return wrappedFields;
    }

    /**
     * Creates {@link WrappedField}s from the specified owning object's instance
     * fields. (static-exclusive)
     *
     * @param owner
     * @return
     */
    public AnnotatedConfigurationManager linkInstance(@NotNull Object owner) {
        for (Field field : owner.getClass().getDeclaredFields()) {
            if (!field.isAnnotationPresent(Link.class))
                continue;
            if (Modifier.isStatic(field.getModifiers()))
                continue;

            this.addWrappedField(new WrappedField(owner, field));
        }

        return this;
    }

    /**
     * Creates {@link WrappedField}s from the specified class's static fields.
     *
     * @param cls The class to wrap
     * @return The {@link AnnotatedConfigurationManager} this method was invoked
     *         from
     */
    @NotNull
    public AnnotatedConfigurationManager linkClass(@NotNull Class<?> cls) {
        for (Field field : cls.getDeclaredFields()) {
            if (!field.isAnnotationPresent(Link.class))
                continue;
            if (!Modifier.isStatic(field.getModifiers()))
                continue;

            this.addWrappedField(new WrappedField(null, field));
        }

        return this;
    }

    /**
     * Creates {@link WrappedField}s from the specified owning object's fields.
     * (static-inclusive)
     *
     * @param owner The owning object to wrap
     * @return The {@link AnnotatedConfigurationManager} this method was invoked
     *         from
     */
    @NotNull
    public AnnotatedConfigurationManager link(@NotNull Object owner) {
        for (Field field : owner.getClass().getDeclaredFields()) {
            if (!field.isAnnotationPresent(Link.class))
                continue;

            this.addWrappedField(new WrappedField(owner, field));
        }

        return this;
    }

    private boolean addWrappedField(@NotNull WrappedField wcf) {
        return wrappedFields.add(wcf);
    }

    private boolean removeWrappedField(@NotNull WrappedField wcf) {
        return wrappedFields.remove(wcf);
    }

    public void load() {
        for (WrappedField wf : wrappedFields) {
            if (!wf.tryGet(def -> wf.trySet(adapter.get(wf.getPath(), def)))) {
                wf.trySet(adapter.get(wf.getPath()));
            }
        }
    }
}
