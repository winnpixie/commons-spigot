package io.github.winnpixie.hukkit.reflection;

public class ReflectedClass {
    private final Class<?> realClass;

    public ReflectedClass(Class<?> realClass) {
        this.realClass = realClass;
    }

    public Class<?> getRealClass() {
        return realClass;
    }

    public ReflectedField getField(String name) throws NoSuchFieldException {
        return new ReflectedField(realClass.getField(name), this);
    }

    public ReflectedField getDeclaredField(String name) throws NoSuchFieldException {
        return new ReflectedField(realClass.getDeclaredField(name), this);
    }
}
