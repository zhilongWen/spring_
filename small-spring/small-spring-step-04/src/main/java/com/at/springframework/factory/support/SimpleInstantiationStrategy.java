package com.at.springframework.factory.support;

import com.at.springframework.BeanException;
import com.at.springframework.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @create 2023-08-23
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiation(BeanDefinition beanDefinition, String beanName, Constructor ctro, Object[] args) throws BeanException {

        Class beanClass = beanDefinition.getBeanClass();

        try {
            if (null != ctro) {
                return beanClass.getDeclaredConstructor(ctro.getParameterTypes()).newInstance(args);
            } else {
                return beanClass.getDeclaredConstructor().newInstance();
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new BeanException("Fail to instantiate [ " + beanClass.getName() + " ]", e);
        }


    }
}
