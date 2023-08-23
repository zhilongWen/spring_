package com.at.springframework;

import java.util.ArrayList;
import java.util.List;

/**
 * @create 2023-08-23
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValuesList = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue) {
        this.propertyValuesList.add(propertyValue);
    }

    public PropertyValue[] getPropertyValues() {
        return propertyValuesList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue propertyValue : this.propertyValuesList) {
            if (propertyValue.getName().equals(propertyName)) {
                return propertyValue;
            }
        }

        return null;
    }

}
