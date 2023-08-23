package com.at.springframework.factory.support;

import com.at.springframework.BeanException;
import com.at.springframework.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * @create 2023-08-23
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    protected BeanDefinition getBeanDefinition(String name) throws BeanException {
        return beanDefinitionMap.get(name);
    }

    @Override
    public void registryBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }
}
