package com.at.springframework.beans.factory;

import com.at.springframework.beans.BeansException;

import java.util.Map;

/**
 * @create 2023-09-02
 */
public interface ListableBeanFactory extends BeanFactory{

    /**
     * 获取当前类型下的 bean 实例
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String,T> getBeansOfType(Class<T> type) throws BeansException;


    String[] getBeanDefinitionNames();

}
