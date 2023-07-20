package io.github.winnpixie.hukkit.reflection;

public class Reflector {
    public static ReflectedClass getClass(String clsName) throws ClassNotFoundException {
        return new ReflectedClass(Class.forName(clsName));
    }

    public static ReflectedClass getClass(Class<?> realClass) {
        return new ReflectedClass(realClass);
    }
}
