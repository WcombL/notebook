package com.zrkj.algorithm.hash;

/**
 * Thomas Wang’s 32 bit Mix Function
 *
 * Redis对于Key是整数类型时用了这个算法
 */
public class ThomasWangHash {

    public int hash32shift(int key) {
        // key = (key << 15) - key - 1;
        key = ~key + (key << 15);
        key = key ^ (key >>> 12);
        key = key + (key << 2);
        key = key ^ (key >>> 4);
        // key = (key + (key << 3)) + (key << 11);
        key = key * 2057;
        key = key ^ (key >>> 16);
        return key;
    }
}
