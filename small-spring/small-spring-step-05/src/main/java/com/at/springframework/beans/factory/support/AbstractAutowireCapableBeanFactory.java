package com.at.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.at.springframework.beans.BeansException;
import com.at.springframework.beans.PropertyValue;
import com.at.springframework.beans.PropertyValues;
import com.at.springframework.beans.factory.config.BeanDefinition;
import com.at.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * @create 2023-08-26
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {


    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {

        Object bean = null;

        try {

            bean = createBeanInstance(beanDefinition, beanName, args);

            applyPropertyValues(beanName, bean, beanDefinition);

        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingleton(beanName, bean);

        return bean;

    }

    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {

        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {

                String fieldName = propertyValue.getName();
                Object fieldValue = propertyValue.getValue();

                if (fieldValue instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) fieldValue;
                    fieldValue = getBean(beanReference.getBeanName());
                }

                BeanUtil.setFieldValue(bean, fieldName, fieldValue);

            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }


    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {

        Constructor ctor = null;

        Class beanClass = beanDefinition.getBeanClass();
        Constructor[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor constructor : declaredConstructors) {
            if (null != args && args.length == constructor.getParameterTypes().length) {
                ctor = constructor;
                break;
            }
        }

        return getInstantiationStrategy().instantiate(beanDefinition, beanName, ctor, args);
    }

}
