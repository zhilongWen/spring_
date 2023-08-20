package com.at.springframework.support;

import com.at.springframework.BeansException;

/**
 * @create 2023-08-20
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    Object getBean(String name,Object ... args) throws BeansException;

}
