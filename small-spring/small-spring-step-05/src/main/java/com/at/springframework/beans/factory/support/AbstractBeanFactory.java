package com.at.springframework.beans.factory.support;

import com.at.springframework.beans.BeansException;
import com.at.springframework.beans.factory.BeanFactory;
import com.at.springframework.beans.factory.config.BeanDefinition;

/**
 * @create 2023-08-26
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws Exception {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requestType) throws BeansException {
        return (T) getBean(name);
    }


    protected <T> T doGetBean(final String name, final Object[] args) {

        Object bean = getSingleton(name);

        if (null != bean) {
            return (T) bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);

        return (T) createBean(name, beanDefinition, args);

    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;


}
