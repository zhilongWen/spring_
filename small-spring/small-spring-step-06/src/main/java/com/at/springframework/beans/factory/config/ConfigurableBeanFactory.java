package com.at.springframework.beans.factory.config;

import com.at.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @create 2023-09-01
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}

