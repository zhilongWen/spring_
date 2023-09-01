package com.at.springframework.beans.factory.support;

import com.at.springframework.beans.BeansException;
import com.at.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @create 2023-09-01
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {

        Class beanClass = beanDefinition.getBeanClass();

        try {

            if (null != ctor){
                return beanClass.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            }else{
                return beanClass.getDeclaredConstructor().newInstance();
            }

        }catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e){
            throw new BeansException("Failed to instantiate [" + beanClass.getName() + "]", e);
        }

    }
}
