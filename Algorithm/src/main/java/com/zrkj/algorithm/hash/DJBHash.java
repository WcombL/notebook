package com.zrkj.algorithm.hash;

/**
 * DJB hash 算法
 */
public class DJBHash {

    public static int hash(String str){

        // 5381和33。为什么是这两个数？经过大量实验，这两个的结果碰撞小，哈希结果分散。
        int hash = 5381;

        char val[] = str.toCharArray();

        for (int i = 0; i < val.length; i++) {
            /* hash * 33 + c */
            // 2^5 = 32
            // 移位
            hash = ((hash << 5) + hash) + val[i];
        }
        return hash;
    }
}
