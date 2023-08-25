package com.at.springframework.beans.factory;

import com.at.springframework.beans.BeansException;

/**
 * @create 2023-08-26
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws Exception;

    /**
     * 按照类型获取 Bean 的方法
     * @param name
     * @param requestType
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> T getBean(String name, Class<T> requestType) throws BeansException;

}
