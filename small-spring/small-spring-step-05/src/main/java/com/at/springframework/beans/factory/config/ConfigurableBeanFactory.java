package com.at.springframework.beans.factory.config;

import com.at.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * 可获取 BeanPostProcessor、BeanClassLoader等的一个配置化接口
 * @create 2023-08-26
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry{


    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

}
