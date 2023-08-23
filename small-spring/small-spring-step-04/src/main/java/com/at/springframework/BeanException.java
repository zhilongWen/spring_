package com.at.springframework;

/**
 * @create 2023-08-23
 */
public class BeanException extends RuntimeException {

    public BeanException() {
        super();
    }

    public BeanException(String msg) {
        super(msg);
    }

    public BeanException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
