package com.jvm;

import java.io.*;

public class MyClassLoader extends ClassLoader {

    private String classPath;

    public MyClassLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] classData = getData(name);
            if (classData == null) {
                throw new Exception("class 文件为空");
            } else {
                return defineClass(name, classData, 0, classData.length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

//    返回类的字节码
    private byte[] getData(String name) throws IOException {
        InputStream inputStream = null;
        ByteArrayOutputStream outputStream = null;
        String path = classPath + File.separatorChar + name.replace('.', File.separatorChar) + ".class";
        try {
            inputStream = new FileInputStream(path);
            outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[2048];
            int len = 0;
            while (true) {
                len = inputStream.read(buffer);
                if (len==0 || len==-1){
                    break;
                }
                outputStream.write(buffer, 0, len);
            }
            return outputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
            outputStream.close();
        }
        return null;
    }
}
