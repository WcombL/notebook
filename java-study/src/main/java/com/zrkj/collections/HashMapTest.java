package com.zrkj.collections;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

  public static void main(String[] args) throws Exception {
    Map<String,String> map = new HashMap<>();

    map.put("hahaha", "hollischuang");

    Class<?> mapType = map.getClass();
    Method capacity = mapType.getDeclaredMethod("capacity");
    capacity.setAccessible(true);
    System.out.println("capacity : " + capacity.invoke(map));
  }
}
