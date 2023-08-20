package com.at.springframework.support;

import com.at.springframework.BeansException;
import com.at.springframework.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @create 2023-08-20
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {

        Object bean = null;

        try {
            bean = createBeanInstance(beanDefinition,beanName,args);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingleton(beanName,bean);

        return bean;

    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args){

        Constructor c = null;

        Class beanClass = beanDefinition.getBeanClass();
        Constructor[] declaredConstructors = beanClass.getDeclaredConstructors();

        for (Constructor constructor : declaredConstructors) {
            if (null != args && args.length == constructor.getParameterTypes().length){
                c = constructor;
                break;
            }
        }

        return getInstantiationStrategy().instantiate(beanDefinition,beanName,c,args);

    }

    public InstantiationStrategy getInstantiationStrategy(){
        return this.instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
