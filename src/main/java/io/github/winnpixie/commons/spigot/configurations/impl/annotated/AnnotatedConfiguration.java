package io.github.winnpixie.commons.spigot.configurations.impl.annotated;

import io.github.winnpixie.commons.spigot.configurations.Configuration;
import io.github.winnpixie.commons.spigot.configurations.ConfigurationAdapter;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * A {@link Configuration} implementation that allows configuration key/values supplied via a
 * {@link ConfigurationAdapter} to be quickly and easily accessed through
 * standard Java fields annotated {@link Link}.
 */
public class AnnotatedConfiguration extends Configuration {
    private static final Predicate<Field> FIELD_VALIDATOR = field ->
            Modifier.isFinal(field.getModifiers()) && field.isAnnotationPresent(Link.class);

    private final Map<String, FieldAccessor> accessorMap = new HashMap<>();

    private void registerField(Object owner, Field field) {
        Link link = field.getAnnotation(Link.class);
        if (link == null) throw new RuntimeException("@Link annotation was null");

        accessorMap.put(link.path(), new FieldAccessor(owner, field));
    }

    /**
     * Registers links with non-static members of the provided object instance.
     *
     * @param obj The object instance to link with
     */
    public void linkInstance(@NotNull Object obj) {
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers())) continue;
            if (!FIELD_VALIDATOR.test(field)) continue;

            registerField(obj, field);
        }
    }

    /**
     * Registers links with static members of the provided class.
     *
     * @param cls The class to link field data from
     */
    public void linkStatic(@NotNull Class<?> cls) {
        for (Field field : cls.getDeclaredFields()) {
            if (!Modifier.isStatic(field.getModifiers())) continue;
            if (!FIELD_VALIDATOR.test(field)) continue;

            registerField(null, field);
        }
    }

    @Override
    public void load() {
        accessorMap.forEach((path, field) -> field.setValue(getConfigurationAdapter().get(path, field.getValue())));
    }

    @Override
    public void save() {
        accessorMap.forEach((path, field) -> getConfigurationAdapter().set(path, field.getValue()));
    }
}
