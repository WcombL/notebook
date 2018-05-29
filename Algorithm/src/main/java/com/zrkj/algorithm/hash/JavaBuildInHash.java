package com.zrkj.algorithm.hash;

/**
 * Java 内置Hash算法
 */
public class JavaBuildInHash {

    public static int hash(String str){
        int hash = 0;

        char val[] = str.toCharArray();

        for (int i = 0; i < val.length; i++) {
            hash = 31 * hash + val[i];
        }
        return hash;
    }
}
