package com.at.springframework.beans.factory.config;

/**
 * @create 2023-09-02
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

}
