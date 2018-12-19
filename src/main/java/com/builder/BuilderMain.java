package com.builder;

public class BuilderMain {

    public static void main(String[] args) {
        PersonBuilder builder = new PersonBuilder.Builder("王竑","武林壹号").age(25).build();
        System.out.println(builder.getName()+builder.getAddress()+builder.getAge());
    }
}
