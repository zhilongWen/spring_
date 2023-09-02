package com.at.springframework.beans.factory;

/**
 * @create 2023-09-02
 */
public interface InitializingBean {

    /**
     * Bean 处理了属性填充后调用
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;

}
