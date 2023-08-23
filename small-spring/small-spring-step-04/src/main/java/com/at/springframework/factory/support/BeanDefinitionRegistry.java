package com.at.springframework.factory.support;

import com.at.springframework.factory.config.BeanDefinition;

/**
 * @create 2023-08-23
 */
public interface BeanDefinitionRegistry {

    void registryBeanDefinition(String name, BeanDefinition beanDefinition);

}
