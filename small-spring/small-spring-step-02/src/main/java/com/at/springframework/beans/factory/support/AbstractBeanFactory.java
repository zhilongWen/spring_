package com.at.springframework.beans.factory.support;

import com.at.springframework.beans.BeansException;
import com.at.springframework.beans.factory.BeanFactory;
import com.at.springframework.beans.factory.config.BeanDefinition;

/**
 * @create 2023-08-15
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {

        Object bean = getSingleton(name);

        if (null != bean) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);

    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

}
