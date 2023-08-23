package com.at.springframework.factory.support;

import com.at.springframework.BeanException;
import com.at.springframework.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * @create 2023-08-23
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiation(BeanDefinition beanDefinition, String beanName, Constructor ctro, Object[] args) throws BeanException {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });

        if (null == ctro) return enhancer.create();

        return enhancer.create(ctro.getParameterTypes(), args);


    }
}
