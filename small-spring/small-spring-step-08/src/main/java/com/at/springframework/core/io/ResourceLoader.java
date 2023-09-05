package com.at.springframework.core.io;

/**
 * @create 2023-09-02
 */
public interface ResourceLoader {


    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);

}
