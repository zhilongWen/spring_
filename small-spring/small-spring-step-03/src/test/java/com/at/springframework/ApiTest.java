package com.at.springframework;

import com.at.springframework.bean.UserService;
import com.at.springframework.config.BeanDefinition;
import com.at.springframework.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @create 2023-08-20
 */
public class ApiTest {

    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 3. 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 4.获取bean
        UserService userService = (UserService) beanFactory.getBean("userService", "小傅哥");
        userService.queryUserInfo();
    }

}
