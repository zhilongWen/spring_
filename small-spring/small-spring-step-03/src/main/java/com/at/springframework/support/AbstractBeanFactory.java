package com.at.springframework.support;

import com.at.springframework.BeansException;
import com.at.springframework.config.BeanDefinition;

/**
 * @create 2023-08-20
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory{

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name,null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name,args);
    }

    protected Object doGetBean(final String name,final Object[] args){

        Object object = getSingleton(name);

        if (null != object){
            return object;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);

        return createBean(name,beanDefinition,args);


    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName,BeanDefinition beanDefinition,Object[] args) throws BeansException;


}
