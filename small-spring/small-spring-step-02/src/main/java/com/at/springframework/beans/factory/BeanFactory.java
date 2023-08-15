package com.at.springframework.beans.factory;

import com.at.springframework.beans.BeansException;

/**
 * @create 2023-08-15
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

}
