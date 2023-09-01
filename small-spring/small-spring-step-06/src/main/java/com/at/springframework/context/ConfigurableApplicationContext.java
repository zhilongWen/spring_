package com.at.springframework.context;

import com.at.springframework.beans.BeansException;

/**
 * @create 2023-09-01
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;


}
