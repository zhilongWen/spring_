package com.at.springframework;

import com.at.springframework.bean.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @create 2023-08-15
 */
public class ApiTest {

    BeanFactory beanFactory;

    @Before
    public void before() {
        // 1.初始化 BeanFactory
        beanFactory = new BeanFactory();
    }

    @After
    public void after() {

        beanFactory = null;

    }

    @Test
    public void test0() {


        // 2.注入 bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.获取bean
        final UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

}
