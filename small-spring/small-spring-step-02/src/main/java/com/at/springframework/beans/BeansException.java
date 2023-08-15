package com.at.springframework.beans;

/**
 * @create 2023-08-15
 */
public class BeansException extends RuntimeException{

    public BeansException(String msg){
        super(msg);
    }

    public BeansException(String msg,Throwable cause){
        super(msg,cause);
    }

}
