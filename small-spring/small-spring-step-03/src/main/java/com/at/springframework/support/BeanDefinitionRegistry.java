package com.at.springframework.support;

import com.at.springframework.config.BeanDefinition;

/**
 * @create 2023-08-20
 */
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
