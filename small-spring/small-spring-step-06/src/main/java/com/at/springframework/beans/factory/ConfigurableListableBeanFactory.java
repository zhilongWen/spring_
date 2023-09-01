package com.at.springframework.beans.factory;

import com.at.springframework.beans.BeansException;
import com.at.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.at.springframework.beans.factory.config.BeanDefinition;
import com.at.springframework.beans.factory.config.BeanPostProcessor;
import com.at.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @create 2023-09-01
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

    @Override
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);


}
