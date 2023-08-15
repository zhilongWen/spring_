package com.at.springframework.beans.factory.support;

import com.at.springframework.beans.BeansException;
import com.at.springframework.beans.factory.config.BeanDefinition;

/**
 * @create 2023-08-15
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {

        Object bean = null;

        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed",e);
        }

        addSingleton(beanName,bean);

        return bean;

    }
}
