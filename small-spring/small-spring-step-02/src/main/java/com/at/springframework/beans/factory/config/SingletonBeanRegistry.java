package com.at.springframework.beans.factory.config;

/**
 * @create 2023-08-15
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

}
