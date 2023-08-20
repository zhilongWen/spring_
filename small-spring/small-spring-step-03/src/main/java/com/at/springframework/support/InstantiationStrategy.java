package com.at.springframework.support;

import com.at.springframework.BeansException;
import com.at.springframework.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @create 2023-08-20
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctro,Object[] args) throws BeansException;

}
