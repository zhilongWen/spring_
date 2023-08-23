package com.at.springframework.factory.support;

import com.at.springframework.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @create 2023-08-23
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String,Object> singletonBeanMap = new HashMap<>();

    @Override
    public Object getSingletonBean(String name) {
        return singletonBeanMap.get(name);
    }

    public void addSingletonBean(String name,Object bean){
        singletonBeanMap.put(name,bean);
    }
}
