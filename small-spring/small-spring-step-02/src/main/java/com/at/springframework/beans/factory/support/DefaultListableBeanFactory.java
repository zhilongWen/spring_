package com.at.springframework.beans.factory.support;

import com.at.springframework.beans.BeansException;
import com.at.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * @create 2023-08-15
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {

        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);

        if (null == beanDefinition) throw new BeansException("No bean named ' " + beanName + " ' is defined");

        return beanDefinition;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }
}
