package com.just.demo29;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class PropReflect {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 加载配置文件
        Properties properties = new Properties();
        properties.load(new FileReader("src/com/just/demo29/prop.properties"));
        String classname = (String) properties.get("classname");
        String method = properties.getProperty("method");

        // 获取字节码文件
        Class<?> aClass = Class.forName(classname);

        // 获取构造方法
        Constructor<?> constructor = aClass.getDeclaredConstructor();

        // 创建对象
        Object o = constructor.newInstance();

        // 获取类方法
        Method aClassDeclaredMethod = aClass.getDeclaredMethod(method);

        // 修改权限
        aClassDeclaredMethod.setAccessible(true);

        // 调用方法
        aClassDeclaredMethod.invoke(o);
    }
}
