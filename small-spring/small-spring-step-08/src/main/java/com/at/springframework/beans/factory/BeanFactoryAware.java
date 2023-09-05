package com.at.springframework.beans.factory;

import com.at.springframework.beans.BeansException;

/**
 * @create 2023-09-03
 */
public interface BeanFactoryAware extends Aware {

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}
