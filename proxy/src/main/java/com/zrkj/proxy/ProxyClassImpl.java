package com.zrkj.proxy;

public class ProxyClassImpl implements IProxyClass {

    @Override
    public int doSomething(int num) {
        System.out.println("方法执行中.....");
        return num;
    }
}
