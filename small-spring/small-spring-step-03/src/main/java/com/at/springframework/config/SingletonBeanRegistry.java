package com.at.springframework.config;

/**
 * @create 2023-08-20
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

}
