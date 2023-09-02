package com.at.springframework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import com.at.springframework.beans.BeansException;
import com.at.springframework.beans.factory.DisposableBean;
import com.at.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * @create 2023-09-02
 */
public class DisposableBeanAdapter implements DisposableBean {

    private final Object bean;
    private final String beanName;
    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {

        // 1.实现 DisposableBean 接口
        if (bean instanceof DisposableBean){
            ((DisposableBean)bean).destroy();
        }

        // 2. 配置信息 destroy-method {判断是为了避免二次执行销毁}
        if (StrUtil.isNotBlank(destroyMethodName) && !(bean instanceof DisposableBean && "destroy".equals(destroyMethodName))){
            Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
            if (null == destroyMethod) {
                throw new BeansException("Couldn't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            }
            destroyMethod.invoke(bean);
        }

    }
}
