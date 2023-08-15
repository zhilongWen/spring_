package com.at.springframework.beans.factory.support;

import com.at.springframework.beans.factory.config.BeanDefinition;

/**
 * @create 2023-08-15
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册 BeanDefinition
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
