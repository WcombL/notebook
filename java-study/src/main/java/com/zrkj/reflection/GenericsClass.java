package com.zrkj.reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GenericsClass {

    protected List<String> stringList = new ArrayList<>();

    public List<String> getStringList(){
        return this.stringList;
    }

    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException {
        Class _class = GenericsClass.class;

        Method method = _class.getMethod("getStringList");

        Type returnType = method.getGenericReturnType();

        // 返回类型是参数化类型, 即泛型
        if(returnType instanceof ParameterizedType){
            ParameterizedType type = (ParameterizedType) returnType;
            Type[] typeArguments = type.getActualTypeArguments();
            for(Type typeArgument : typeArguments){
                Class typeArgClass = (Class) typeArgument;
                System.out.println("typeArgClass = " + typeArgClass);
            }
        }
    }
}
