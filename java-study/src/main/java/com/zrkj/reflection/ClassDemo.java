package com.zrkj.reflection;

import java.lang.reflect.Modifier;

public class ClassDemo {

    public static void main(String[] args) {
        Class _class = DumpMethods.class;

        System.out.println(_class.getName());
        System.out.println(_class.getSimpleName());

        int modifiers = _class.getModifiers();
        System.out.println(modifiers);
        System.out.println(Modifier.isPublic(modifiers));
    }
}
