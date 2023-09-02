package com.at.springframework;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import com.at.springframework.bean.UserService;
import com.at.springframework.beans.factory.config.BeanReference;
import com.at.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.at.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.at.springframework.common.MyBeanFactoryPostProcessor;
import com.at.springframework.common.MyBeanPostProcessor;
import com.at.springframework.context.support.ClassPathXmlApplicationContext;
import com.at.springframework.core.io.DefaultResourceLoader;
import com.at.springframework.core.io.Resource;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

/**
 * @create 2023-09-02
 */
public class ApiTest {

    @Test
    public void testInitAndDestroy(){

        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);



    }

    @Test
    public void testHook(){
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("close！")));
    }


    @Test
    public void test_xmlL() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }


    @Test
    public void test_BeanFactoryPostProcessorAndBeanPostProcessor(){
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. BeanDefinition 加载完成 & Bean实例化之前，修改 BeanDefinition 的属性值
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        // 4. Bean实例化之后，修改 Bean 属性信息
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        // 5. 获取Bean对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }


    @Test
    public void test2() throws Exception {

        Class<?> aClass = Class.forName("com.at.springframework.bean.UserDao");

        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:spring.xml");
        InputStream inputStream = resource.getInputStream();

        Document doc = XmlUtil.readXML(inputStream);
        Element root = doc.getDocumentElement();
        NodeList childNodes = root.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {

            Node beanItem = childNodes.item(i);

            // 判断元素
            if (!(beanItem instanceof Element)) continue;

            // 判断对象
            if (!"bean".equals(beanItem.getNodeName())) continue;

            // 解析标签
            Element bean = (Element) beanItem;
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");

            System.out.println("bean = " + bean + " , id = " + id + " , name = " + name + " , className = " + className);

            // 获取 Class
            Class<?> clazz = Class.forName(className);

            // 优先级 id > name
            String beanName = StrUtil.isNotBlank(id) ? id : name;
            if (StrUtil.isBlank(beanName)) {
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }

            // 定义 bean

            // 读取属性并填充
            for (int j = 0; j < bean.getChildNodes().getLength(); j++) {

                Node propertyItem = bean.getChildNodes().item(j);

                if (!(propertyItem instanceof Element)) continue;

                if (!"property".equals(propertyItem.getNodeName())) continue;

                // 解析 property
                Element property = (Element) propertyItem;
                String attrName = property.getAttribute("name");
                String attrValue = property.getAttribute("value");
                String attrRef = property.getAttribute("ref");

                // 获取属性值：引入对象、值对象
                Object value = StrUtil.isNotBlank(attrRef) ? new BeanReference(attrRef) : attrValue;


                System.out.println("attrName = " + attrName + " , attrValue = " + attrValue + " , attrRef = " + attrRef + " , value =  " + value);

            }


        }

    }


    @Test
    public void test1() throws IOException {

        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();

        Resource r1 = resourceLoader.getResource("classpath:important.properties");
        InputStream is1 = r1.getInputStream();
        System.out.println(IoUtil.readUtf8(is1));

        System.out.println("");
        System.out.println("=====================================");


        Resource r2 = resourceLoader.getResource("src/test/resources/important.properties");
        System.out.println(IoUtil.readUtf8(r2.getInputStream()));


        System.out.println("");
        System.out.println("=====================================");

        Resource r3 = resourceLoader.getResource("src/test/resources/spring.xml");
        System.out.println(IoUtil.readUtf8(r3.getInputStream()));

        System.out.println("");
        System.out.println("=====================================");

        Resource r4 = resourceLoader.getResource("classpath:spring.xml");
        System.out.println(IoUtil.readUtf8(r4.getInputStream()));


    }

}
