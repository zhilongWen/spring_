package com.at.springframework.factory;

/**
 * @create 2023-08-23
 */
public interface BeanFactory {

    Object getBean(String beanName);

    Object getBean(String beanName, Object... args);

}
