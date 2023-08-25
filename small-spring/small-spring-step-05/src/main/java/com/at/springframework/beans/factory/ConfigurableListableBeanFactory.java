package com.at.springframework.beans.factory;

import com.at.springframework.beans.BeansException;
import com.at.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.at.springframework.beans.factory.config.BeanDefinition;

/**
 * 提供分析和修改Bean以及预先实例化的操作接口，不过目前只有一个 getBeanDefinition 方法
 *
 * @create 2023-08-26
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

}
