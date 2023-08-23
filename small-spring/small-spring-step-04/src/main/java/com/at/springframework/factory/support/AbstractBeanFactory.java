package com.at.springframework.factory.support;

import com.at.springframework.BeanException;
import com.at.springframework.factory.BeanFactory;
import com.at.springframework.factory.config.BeanDefinition;

/**
 * @create 2023-08-23
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {


    @Override
    public Object getBean(String beanName) {
        return doGetBean(beanName, null);
    }

    @Override
    public Object getBean(String beanName, Object... args) {
        return doGetBean(beanName, args);
    }

    public Object doGetBean(String beanName, Object[] args) {

        Object bean = getSingletonBean(beanName);

        if (null != bean) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(beanName);

        return createBean(beanName, beanDefinition, args);

    }

    protected abstract BeanDefinition getBeanDefinition(String name) throws BeanException;

    protected abstract Object createBean(String name, BeanDefinition beanDefinition, Object[] args) throws BeanException;

}
