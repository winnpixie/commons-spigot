package io.github.winnpixie.hukkit.reflection;

import java.lang.reflect.Field;

public class ReflectedField extends ReflectedMember<Field> {
    public ReflectedField(Field field, ReflectedClass owner) {
        super(field, owner);
    }

    public Object getValue(Object owner) throws IllegalAccessException {
        return getMember().get(owner);
    }

    public void setValue(Object owner, Object value) throws IllegalAccessException {
        getMember().set(owner, value);
    }
}
