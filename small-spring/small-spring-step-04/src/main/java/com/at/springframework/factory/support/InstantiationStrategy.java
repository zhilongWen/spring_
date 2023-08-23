package com.at.springframework.factory.support;

import com.at.springframework.BeanException;
import com.at.springframework.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @create 2023-08-23
 */
public interface InstantiationStrategy {

    Object instantiation(BeanDefinition beanDefinition, String beanName, Constructor ctro,Object[] args) throws BeanException;

}
