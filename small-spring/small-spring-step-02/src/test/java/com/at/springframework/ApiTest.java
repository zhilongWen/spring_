package com.at.springframework;

import com.at.springframework.bean.HelloWord;
import com.at.springframework.bean.UserService;
import com.at.springframework.beans.factory.config.BeanDefinition;
import com.at.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @create 2023-08-15
 */
public class ApiTest {


    @Test
    public void test() {

        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.第一次获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

        // 4.第二次获取 bean
        UserService userService2 = (UserService) beanFactory.getBean("userService");
        userService2.queryUserInfo();

        System.out.println(userService == userService2);

        System.out.println("=======================================");


        beanFactory.registerBeanDefinition("HelloWord",new BeanDefinition(HelloWord.class));
        final HelloWord aaa = (HelloWord) beanFactory.getBean("HelloWord");
        System.out.println(aaa.say());


    }


}
