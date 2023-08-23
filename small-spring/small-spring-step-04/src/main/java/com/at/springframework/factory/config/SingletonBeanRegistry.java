package com.at.springframework.factory.config;

/**
 * @create 2023-08-23
 */
public interface SingletonBeanRegistry {

    Object getSingletonBean(String name);

}
