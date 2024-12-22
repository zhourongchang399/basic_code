package com.just.demo30;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtils {

    // 创建代理对象
    public static Star creatProxyForStar(BigStar bigStar) {

        Star instance = (Star) Proxy.newProxyInstance(ProxyUtils.class.getClassLoader(), new Class[]{Star.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 代理执行方法
                if (method.getName().equals("sing")) {
                    System.out.println("准备喇叭，收钱！");
                } else if (method.getName().equals("dance")) {
                    System.out.println("准备舞池，收钱！");
                }
                return method.invoke(bigStar, args);
            }
        });

        return instance;

    }
}
