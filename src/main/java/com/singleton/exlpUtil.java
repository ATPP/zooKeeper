package com.singleton;

public class exlpUtil {
    //不能被实例化
    //写一个构造器，不产生默认构造器，防止被实例化
    private exlpUtil(){
        throw new AssertionError();
    }
}
