package com.builder;

import java.util.Date;

public class PersonBuilder {

    //必有变量
    private String name;
    private String address;
    //可选变量
    private int age;
    private double salarry;
    private Date birthDay;

    //static的Builder类
    public static class Builder {
        //成员变量应该会被赋予初始值
        //必有变量
        private String name;
        private String address;
        //可选变量
        private int age;
        private double salarry;
        private Date birthDay;

        public Builder(String name, String address) {
            this.name = name;
            this.address = address;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder salarry(double salarry) {
            this.salarry = salarry;
            return this;
        }

        public Builder birthDay(Date birthDay) {
            this.birthDay = birthDay;
            return this;
        }

        public PersonBuilder build() {
            return new PersonBuilder(this);
        }
    }

    private PersonBuilder(Builder builder) {
        this.age = builder.age;
        this.address = builder.address;
        this.name = builder.name;
        this.salarry = builder.salarry;
        this.birthDay = builder.birthDay;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public Date getBirthDay() {
        return birthDay;
    }
}
