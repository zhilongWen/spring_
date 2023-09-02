package com.at.springframework.beans.factory.support;

import com.at.springframework.beans.BeansException;
import com.at.springframework.beans.factory.config.BeanDefinition;
import com.at.springframework.beans.factory.config.BeanPostProcessor;
import com.at.springframework.beans.factory.config.ConfigurableBeanFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @create 2023-09-02
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {

    /** BeanPostProcessors to apply in createBean */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class type) throws BeansException {
        return (T) doGetBean(name, null);
    }

    protected <T> T doGetBean(String beanName, Object[] args) {

        Object bean = getSingleton(beanName);

        if (bean != null) return (T) bean;

        BeanDefinition beanDefinition = getBeanDefinition(beanName);

        return (T) createBean(beanName, beanDefinition, args);

    }

    protected abstract BeanDefinition getBeanDefinition(String name) throws BeansException;

    protected abstract Object createBean(String name, BeanDefinition beanDefinition, Object[] args) throws BeansException;


    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        beanPostProcessors.remove(beanPostProcessor);
        beanPostProcessors.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return beanPostProcessors;
    }
}
