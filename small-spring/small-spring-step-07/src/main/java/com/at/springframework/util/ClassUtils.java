package com.at.springframework.util;

/**
 * @create 2023-09-02
 */
public class ClassUtils {

    public static ClassLoader getDefaultClassLoader() {

        ClassLoader classLoader = null;

        try {
            classLoader = Thread.currentThread().getContextClassLoader();
        } catch (Throwable ex) {
            // Cannot access thread context ClassLoader - falling back to system class loader.
        }

        if (classLoader == null) {
            // No thread context class loader -> use class loader of this class.
            classLoader = ClassUtils.getDefaultClassLoader();
        }

        return classLoader;

    }

}
