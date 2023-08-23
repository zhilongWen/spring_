package com.at.springframework;

import com.at.springframework.bean.UserDao;
import com.at.springframework.bean.UserService;
import com.at.springframework.factory.config.BeanDefinition;
import com.at.springframework.factory.config.BeanReference;
import com.at.springframework.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @create 2023-08-23
 */
public class ApiTest {

    @Test
    public void test2(){

        Field[] fields = UserService.class.getFields();
        System.out.println(Arrays.toString(fields));

        Field[] declaredFields = UserService.class.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields));

        Class<? super UserService> superclass = UserService.class.getSuperclass();
        System.out.println(superclass);
        Field[] declaredFields1 = superclass.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields1));

    }


    @Test
    public void test1(){

        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. UserDao 注册
        beanFactory.registryBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 3. UserService 设置属性[uId、userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

        // 4. UserService 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registryBeanDefinition("userService", beanDefinition);

        // 5. UserService 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

    }


    @Test
    public void test0(){

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        beanFactory.registryBeanDefinition("userService",new BeanDefinition(UserService.class));

        UserService userService = (UserService) beanFactory.getBean("userService","2312");
        userService.queryUserInfo();

        UserService userService1 = (UserService) beanFactory.getBean("userService");
        userService1.queryUserInfo();

    }

}
