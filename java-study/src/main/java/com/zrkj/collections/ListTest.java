package com.zrkj.collections;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {
        List<String> source = new ArrayList<>();
        source.add("a");
        source.add("b");
        source.add("c");
        source.add("d");
        source.add("e");

        List<String> target = new ArrayList<>();
        target.add("a");
        target.add("b");
        target.add("c");
        target.add("f");

        source.retainAll(target);
        // a b c
        System.out.println(source);


        int a = 10;
        System.out.println(a>>1);
    }
}
