package io.github.winnpixie.commons.spigot.configurations.impl.annotated;

import java.lang.reflect.Field;

record FieldAccessor(Object owner, Field field) {
    public FieldAccessor(Object owner, Field field) {
        this.owner = owner;
        this.field = field;

        if (!field.canAccess(owner)) field.trySetAccessible();
    }

    public Object getValue() {
        try {
            return field.get(owner);
        } catch (IllegalAccessException iae) {
            iae.printStackTrace();
        }

        return null;
    }

    public boolean setValue(Object value) {
        try {
            field.set(owner, value);
            return true;
        } catch (IllegalAccessException iae) {
            iae.printStackTrace();
        }

        return false;
    }
}
