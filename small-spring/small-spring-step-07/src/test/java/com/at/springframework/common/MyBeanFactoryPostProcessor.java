package com.at.springframework.common;

import com.at.springframework.beans.BeansException;
import com.at.springframework.beans.PropertyValue;
import com.at.springframework.beans.PropertyValues;
import com.at.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.at.springframework.beans.factory.config.BeanDefinition;
import com.at.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @create 2023-09-01
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }

}
