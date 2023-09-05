package com.at.springframework.beans;

/**
 * @create 2023-09-02
 */
public class BeansException extends RuntimeException{

    public BeansException() {
    }

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
