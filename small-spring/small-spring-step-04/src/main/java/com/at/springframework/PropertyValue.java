package com.at.springframework;

/**
 * @create 2023-08-23
 */
public class PropertyValue {

    private final String name;

    public final Object value;

    public PropertyValue(String name,Object value){
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
