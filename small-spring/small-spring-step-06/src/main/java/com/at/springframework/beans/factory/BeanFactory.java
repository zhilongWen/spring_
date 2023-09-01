package com.at.springframework.beans.factory;

import com.at.springframework.beans.BeansException;

/**
 * @create 2023-09-01
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    Object getBean(String name,Object ... args) throws BeansException;

    <T> T getBean(String name,Class<T> type) throws BeansException;

}
