package com.at.springframework.support;

import com.at.springframework.BeansException;
import com.at.springframework.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @create 2023-08-20
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctro, Object[] args) throws BeansException {

        Class beanClass = beanDefinition.getBeanClass();

        try {

            if (null != ctro){
                return beanClass.getDeclaredConstructor(ctro.getParameterTypes()).newInstance(args);
            }else{
                return beanClass.getDeclaredConstructor().newInstance();
            }

        }catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new BeansException("Failed to instantiate [" + beanClass.getName() + "]", e);
        }

    }
}
