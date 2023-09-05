package com.at.springframework.context;

import com.at.springframework.beans.BeansException;
import com.at.springframework.beans.factory.Aware;

/**
 * @create 2023-09-03
 */
public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
