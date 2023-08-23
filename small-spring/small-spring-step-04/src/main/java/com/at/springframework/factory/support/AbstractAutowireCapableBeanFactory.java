package com.at.springframework.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.at.springframework.BeanException;
import com.at.springframework.PropertyValue;
import com.at.springframework.PropertyValues;
import com.at.springframework.factory.config.BeanDefinition;
import com.at.springframework.factory.config.BeanReference;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @create 2023-08-23
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
    protected Object createBean(String name, BeanDefinition beanDefinition, Object[] args) throws BeanException {

        Object bean = null;

        try {
            bean = createBeanInstance(beanDefinition, name, args);

            // 给 Bean 填充属性
            applyPropertyValues(name,bean,beanDefinition);

        } catch (Exception e) {
            throw new BeanException("Instantiation of bean failed", e);
        }

        addSingletonBean(name, bean);

        return bean;

    }

    private Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {

        Constructor ctor = null;

        Class beanClass = beanDefinition.getBeanClass();
        Constructor[] declaredConstructors = beanClass.getDeclaredConstructors();

        for (Constructor constructor : declaredConstructors) {
            if (null != args && args.length == constructor.getParameterTypes().length) {
                ctor = constructor;
                break;
            }
        }

        return getInstantiationStrategy().instantiation(beanDefinition, beanName, ctor, args);

    }

    private void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {

        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();

            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {

                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference){
                    // A 依赖 B，获取 B 的实例化
                    BeanReference beanReference = (BeanReference) (value);
                    value = getBean(beanReference.getBeanName());
                }
                // 属性填充
                BeanUtil.setFieldValue(bean,name,value);

//                setFieldValue(bean,name,value);
            }
        }catch (Exception e){
            throw new BeanException("Error setting property values：" + beanName);
        }


    }


    private void setFieldValue(Object obj,String name,Object value){

        Field[] declaredFields = obj.getClass().getDeclaredFields();

        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            if (declaredField.getName().equals(name)){
                try {
                    declaredField.set(obj,value);
                } catch (IllegalAccessException e) {
                   throw new RuntimeException("属性设置失败");
                }
            }
        }


    }

}
