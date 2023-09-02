package com.at.springframework.common;

import com.at.springframework.bean.UserService;
import com.at.springframework.beans.BeansException;
import com.at.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @create 2023-09-01
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("改为：北京");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}
