package io.github.winnpixie.commons.spigot.configurations;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * An API that allows configuration values supplied via a
 * {@link IConfigurationAdapter} to be quickly and easily accessed through
 * standard Java fields linked by the {@link Link} annotation.
 *
 * @author Hannah
 */
public class AnnotatedConfigurator {
    private IConfigurationAdapter adapter;

    private final List<FieldLinker> linkers = new ArrayList<>(); // or CopyOnWriteArrayList, concurrency go brrrr

    /**
     * Constructs an instance of {@link AnnotatedConfigurator} without an {@link IConfigurationAdapter}.
     */
    public AnnotatedConfigurator() {
    }

    /**
     * Constructs an instance of {@link AnnotatedConfigurator} with an underlying {@link IConfigurationAdapter}.
     *
     * @param adapter The {@link IConfigurationAdapter} to use.
     */
    public AnnotatedConfigurator(@NotNull IConfigurationAdapter adapter) {
        this.adapter = adapter;
    }

    /**
     * @return The underlying {@link IConfigurationAdapter} this instance is using.
     */
    @Nullable
    public IConfigurationAdapter getAdapter() {
        return adapter;
    }

    /**
     * Set the underlying {@link IConfigurationAdapter} for this instance.
     *
     * @param adapter The {@link IConfigurationAdapter} to use.
     * @return The {@link AnnotatedConfigurator} this method was invoked from.
     */
    public AnnotatedConfigurator setAdapter(@NotNull IConfigurationAdapter adapter) {
        this.adapter = adapter;
        return this;
    }

    @NotNull
    public List<FieldLinker> getLinkers() {
        return linkers;
    }

    /**
     * Creates {@link FieldLinker}s from the specified object using instance (and optionally, static) fields.
     *
     * @param obj                 The class to link field data from
     * @param excludeStaticFields Whether to exclude static fields from linking
     * @return The {@link AnnotatedConfigurator} this method was invoked from
     */
    public AnnotatedConfigurator link(@NotNull Object obj, boolean excludeStaticFields) {
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (!field.isAnnotationPresent(Link.class)) continue;
            if (excludeStaticFields && Modifier.isStatic(field.getModifiers())) continue;

            this.addLinker(new FieldLinker(obj, field));
        }

        return this;
    }

    /**
     * Creates {@link FieldLinker}s from the specified class's static fields.
     *
     * @param cls The class to link field data from
     * @return The {@link AnnotatedConfigurator} this method was invoked from
     */
    @NotNull
    public AnnotatedConfigurator linkClass(@NotNull Class<?> cls) {
        for (Field field : cls.getDeclaredFields()) {
            if (!field.isAnnotationPresent(Link.class)) continue;
            if (!Modifier.isStatic(field.getModifiers())) continue;

            this.addLinker(new FieldLinker(null, field));
        }

        return this;
    }

    private boolean addLinker(@NotNull FieldLinker linker) {
        return linkers.add(linker);
    }

    private boolean removeLinker(@NotNull FieldLinker linker) {
        return linkers.remove(linker);
    }

    public void load() {
        for (FieldLinker linker : linkers) {
            if (linker.tryGet(def -> linker.trySet(adapter.get(linker.getPath(), def)))) continue;

            linker.trySet(adapter.get(linker.getPath()));
        }
    }
}
