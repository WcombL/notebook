package com.zrkj.reflection;

import java.lang.reflect.Field;

public class ChangeFieldValue {

    public double d;

    public static void main(String[] args) {
        try {
            Class cls = Class.forName("com.zrkj.reflection.ChangeFieldValue");
            Field fld = cls.getField("d");
            ChangeFieldValue f2obj = new ChangeFieldValue();
            System.out.println("d = " + f2obj.d);
            fld.setDouble(f2obj, 12.34);
            System.out.println("d = " + f2obj.d);

            fld.set(f2obj,"");
            System.out.println("d = " + f2obj.d);
        } catch (Throwable e) {
            System.err.println(e);
        }
    }
}
