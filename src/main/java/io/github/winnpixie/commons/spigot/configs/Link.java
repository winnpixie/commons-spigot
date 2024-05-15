package io.github.winnpixie.commons.spigot.configs;

import org.jetbrains.annotations.NotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marker annotation for configuration fields
 *
 * @author Hannah
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Link {
    /**
     * The (full) path the configuration key.
     * i.e. {@code a.b.c}, where {@code a.b} is the path and {@code c} = the name of
     * the key
     *
     * @return The full path
     */
    @NotNull String path();
}
