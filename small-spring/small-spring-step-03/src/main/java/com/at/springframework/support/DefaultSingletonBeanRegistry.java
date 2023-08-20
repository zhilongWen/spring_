package com.at.springframework.support;

import com.at.springframework.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @create 2023-08-20
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    Map<String,Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    public void addSingleton(String beanName,Object singletonObject){
        singletonObjects.put(beanName,singletonObject);
    }

}
