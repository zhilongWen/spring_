package com.at.springframework.beans.factory;

/**
 * @create 2023-09-03
 */
public interface BeanNameAware extends Aware {

    void setBeanName(String name);
}
