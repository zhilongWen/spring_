package com.at.springframework.beans.factory.config;

import java.util.Set;

/**
 * @create 2023-09-02
 */
public class BeanReference {

    private final String name;

    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
