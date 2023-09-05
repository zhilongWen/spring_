package com.at.springframework.beans.factory;

/**
 * @create 2023-09-03
 */
public interface BeanClassLoaderAware extends Aware{

    void setBeanClassLoader(ClassLoader classLoader);
}
