package com.at.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @create 2023-08-26
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue) {
        propertyValueList.add(propertyValue);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue propertyValue : propertyValueList) {

            if (propertyValue.getName().equals(propertyName)) {
                return propertyValue;
            }

        }

        return null;
    }


}
