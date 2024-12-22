package com.just.demo30;

public class testStar {
    public static void main(String[] args) {
        // 创建对象
        BigStar bigStar = new BigStar("鸡哥", "24");

        // 创建代理
        Star starProxy = ProxyUtils.creatProxyForStar(bigStar);

        // 执行代理
        starProxy.sing("鸡你太美");
        starProxy.dance("顶跨舞");
    }
}
