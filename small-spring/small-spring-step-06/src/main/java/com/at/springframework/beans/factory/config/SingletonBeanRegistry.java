package com.at.springframework.beans.factory.config;

/**
 * @create 2023-09-01
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
