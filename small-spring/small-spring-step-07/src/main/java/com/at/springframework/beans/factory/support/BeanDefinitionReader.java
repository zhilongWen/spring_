package com.at.springframework.beans.factory.support;

import com.at.springframework.beans.BeansException;
import com.at.springframework.beans.factory.config.BeanDefinition;
import com.at.springframework.core.io.Resource;
import com.at.springframework.core.io.ResourceLoader;

/**
 * @create 2023-09-02
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource ... resources) throws Exception;

    void loadBeanDefinitions(String location) throws Exception;

    void loadBeanDefinitions(String ... locations) throws Exception;

}
