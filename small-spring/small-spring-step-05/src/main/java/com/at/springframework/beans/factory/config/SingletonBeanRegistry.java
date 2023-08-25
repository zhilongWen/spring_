package com.at.springframework.beans.factory.config;

/**
 * @create 2023-08-26
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

}
