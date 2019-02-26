package com.javassist;

import javassist.*;

import java.io.IOException;

public class JavassistDemo {

    public static void main(String[] args) throws NotFoundException, CannotCompileException, IOException {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.get("com.javassist.Product");
        CtMethod[] ctMethods = ctClass.getMethods();
        for (CtMethod cm : ctMethods) {
            System.out.println("ctMethod "+cm);
        }
        CtField ctFields = ctClass.getField("name");
//        for (CtField field : ctFields){
            System.out.println("field "+ctFields.getName());
//        }
        CtMethod m = ctClass.getDeclaredMethod("getPrice");
        m.insertBefore("{ System.out.println($1); }");
        ctClass.writeFile();
    }
}
