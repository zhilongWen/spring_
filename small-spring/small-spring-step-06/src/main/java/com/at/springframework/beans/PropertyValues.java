package com.at.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @create 2023-08-31
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue){
        propertyValueList.add(propertyValue);
    }

    public PropertyValue[] getPropertyValues(){
        return propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String name){
        for (PropertyValue propertyValue : this.propertyValueList) {
            if (propertyValue.getName().equals(name)){
                return propertyValue;
            }
        }
        return null;
    }

}
