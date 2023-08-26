package com.at.springframework.beans;

/**
 * @create 2023-08-26
 */
public class BeansException extends RuntimeException{

    public BeansException() {
        super();
    }

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
