package com.at.springframework.beans.factory.support;

import com.at.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @create 2023-09-01
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new HashMap();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }


    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

}
