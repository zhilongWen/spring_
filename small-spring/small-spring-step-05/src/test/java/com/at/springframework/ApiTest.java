package com.at.springframework;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.XmlUtil;
import com.at.springframework.bean.UserService;
import com.at.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.at.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.at.springframework.core.io.DefaultResourceLoader;
import com.at.springframework.core.io.Resource;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

/**
 * @create 2023-08-26
 */
public class ApiTest {

    DefaultResourceLoader resourceLoader;

    @Before
    public void init(){
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_xml() throws Exception {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. 获取Bean对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

    @Test
    public void parseXML() throws IOException {

        Resource resource = resourceLoader.getResource("classpath:spring.xml");

        InputStream is = resource.getInputStream();

//        String content = IoUtil.readUtf8(is);
//
//        System.out.println(content);
//

        System.out.println("===================================");


        Document doc = XmlUtil.readXML(is);
        Element root = doc.getDocumentElement();
        NodeList childNodes = root.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {

            Node itemBean = childNodes.item(i);

            if (!(itemBean instanceof  Element)) continue;
            if (!"bean".equals(itemBean.getNodeName())) continue;


            Element bean = (Element) itemBean;
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");

            System.out.println("id = " + id);
            System.out.println("name = " + name);
            System.out.println("className = " + className);


        }


    }


    @Test
    public void testClasspath() throws IOException {

        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream is = resource.getInputStream();

        String content = IoUtil.readUtf8(is);

        System.out.println(content);

    }

    @Test
    public void testFile() throws IOException {

        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");

        InputStream is = resource.getInputStream();

        String content = IoUtil.readUtf8(is);

        System.out.println(content);
    }

    @Test
    public void testUrl() throws IOException {
        Resource resource = resourceLoader.getResource("https://github.com/zhilongWen/spring_/blob/dev/small-spring/small-spring-step-05/src/main/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

}
