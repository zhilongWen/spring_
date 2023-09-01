package com.at.springframework.beans.factory.config;

/**
 * @create 2023-09-01
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName){
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
