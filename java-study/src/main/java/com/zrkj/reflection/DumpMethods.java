package com.zrkj.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class DumpMethods {

    public static void main(String[] args) {
        try {
            Class _class = Class.forName("com.zrkj.reflection.RefectionDemo");
            // 类中声明的方法
            System.out.println("=============类中声明的方法=============");
            Method[] declaredMethods = _class.getDeclaredMethods();
            for(Method method: declaredMethods){
                System.out.println(method.toString());
            }

            System.out.println("=============所有public方法,包含父类或接口=============");
            Method[] methods = _class.getMethods();
            for (Method method : methods) {
                System.out.println(method.toString());
            }

            System.out.println("=============Class.isInstance 模拟 instanceof 操作=============");
            // Class.isInstance 模拟 instanceof 操作
            boolean b1 = _class.isInstance(new Integer(37));
            System.out.println(b1);
            boolean b2 = _class.isInstance(new RefectionDemo());
            System.out.println(b2);

            System.out.println("=============所有构造函数=============");
            _class = Class.forName("java.util.Stack");
            Constructor[] declaredConstructors = _class.getDeclaredConstructors();
            for (Constructor constructor : declaredConstructors) {
                System.out.println(constructor.toString());
            }

            System.out.println("=============public构造函数=============");
            _class = Class.forName("java.util.Stack");
            Constructor[] constructors = _class.getConstructors();
            for (Constructor constructor : constructors) {
                System.out.println(constructor.toString());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
