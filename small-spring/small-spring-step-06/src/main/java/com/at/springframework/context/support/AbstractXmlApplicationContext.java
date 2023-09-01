package com.at.springframework.context.support;

import com.at.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.at.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @create 2023-09-01
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);

        String[] configLocations = getConfigLocations();
        if (null != configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();

}
