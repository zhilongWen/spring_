package com.at.springframework.context.support;

import com.at.springframework.beans.BeansException;
import com.at.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @create 2023-09-02
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }


    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }


    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException;

    @Override
    public DefaultListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
