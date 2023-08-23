package com.at.springframework;

import java.lang.reflect.Field;

/**
 * @create 2023-08-24
 */
public class CopyFiles {

    public static void main(String[] args) throws Exception {

        A a = new A("123", "A", 2,new Address("bb",123));

        System.out.println(a.toString());

        B b = new B();
        System.out.println(b);


        Field[] declaredFields = a.getClass().getDeclaredFields();

        for (Field field : declaredFields) {
            field.setAccessible(true);
            String fieldName = field.getName();
            System.out.println(a.getClass().getDeclaredField(fieldName));
            System.out.println(field.get(a));

            Object value = field.get(a);
            copyFile(b, fieldName, value);

        }

        System.out.println(b);


    }

    public static void copyFile(Object dest, String fileName, Object value) throws IllegalAccessException {

        Field[] declaredFields = dest.getClass().getDeclaredFields();

        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            if (fileName.equals(declaredField.getName())) {
                declaredField.set(dest, value);
            }

        }


    }


}

class B {
    private String uid;
    private String name;
    private int age;
    private Address address;

    public B(String uid, String name, int age, Address address) {
        this.uid = uid;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public B() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "B{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}

class Address {

    private String province;
    private int code;

    public Address() {
    }

    public Address(String province, int code) {
        this.province = province;
        this.code = code;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", code=" + code +
                '}';
    }
}


class A {

    private String uid;
    private String name;
    private int age;
    private Address address;

    public A(String uid, String name, int age, Address address) {
        this.uid = uid;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public A() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "A{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
