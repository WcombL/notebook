package com.zrkj.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

public class MyInterceptor {

    // 通过CGLIB的Enhancer来指定要代理的目标对象、实际处理代理逻辑的对象，
    // 最终通过调用create()方法得到代理对象，
    // 对这个对象所有非final方法的调用都会转发给MethodInterceptor.intercept()方法，
    // 在intercept()方法里我们可以加入任何逻辑，比如修改方法参数，加入日志功能、安全检查功能等；
    // 通过调用MethodProxy.invokeSuper()方法，我们将调用转发给原始对象

    // CGLIG中MethodInterceptor的作用跟JDK代理中的InvocationHandler很类似，都是方法调用的中转站

    // 对于从Object中继承的方法，CGLIB代理也会进行代理，如hashCode()、equals()、toString()等，
    // 但是getClass()、wait()等方法不会，因为它是final方法，CGLIB无法代理

    // CGLIB是通过继承实现代理；同时实现了net.sf.cglib.proxy.Factory接口
    // 既然是继承就不得不考虑final的问题。我们知道final类型不能有子类，所以CGLIB不能代理final类型
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloConcrete.class);
        enhancer.setCallback(new MyMethodInterceptor());
        HelloConcrete hello = (HelloConcrete)enhancer.create();
        System.out.println(hello.sayHello("I love you!"));
    }
}
