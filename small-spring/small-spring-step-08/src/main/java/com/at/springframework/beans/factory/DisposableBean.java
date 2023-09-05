package com.at.springframework.beans.factory;

/**
 * @create 2023-09-02
 */
public interface DisposableBean {

    void destroy() throws Exception;

}
