package com.zrkj.algorithm.hash;

/**
 * hash 算法
 *
 * DJB hash算法：
 * hash * 33 + c
 * 5381和33。为什么是这两个数？经过大量实验，这两个的结果碰撞小，哈希结果分散。
 *
 *
 * Java 内置hash算法
 * h = 0
 * h = 31 * h + val[i]
 *
 *
 * FNV
 * FNV能快速hash大量数据并保持较小的冲突率，它的高度分散使它适用于hash一些非常相近的字符串，比如URL，hostname，文件名，text，IP地址等
 *
 * FNV算法有两个版本FNV-1和FNV-1a
 *
 * 字符串每一位都看成是一个数字，32位的话看成是16777169进制的数字，计算当前串的哈希值就是在把当前串转成10进制
 * 这个算法的厉害之处在于他可以保存状态。
 * 比如有个字符串ab，它的哈希值是a*E+b=HashAB，如果计算bc的哈希值，可以利用第一次计算的结果(HashAB-a*E)*E+c=HashBC。
 * 这么一个转换例子里是两个字符效果不明显，如果当前串是100个字符，后移一位的哈希算法性能就会快很多
 * 在Golang里面字符串匹配算法查找用到了这个
 *
 *
 * Thomas Wang’s 32 bit Mix Function
 * 整数的哈希算法
 *
 *
 * Murmur
 * 就纯哈希算法来说，这个算法算是综合能力不错的算法了。碰撞小、性能好
 *
 * CRC32
 * CRC32的哈希碰撞和murmur的差不多，但是CRC32可以使用CPU的硬件加速实现哈希提速。
 * 在Codis上就使用了这个哈希算法做哈希分片，SlotId= crc32(key) % 1024。
 * Codis使用Go语言实现，CRC32算法直接用了Go的原生包hash/crc32。这个包会提前判断当前CPU是否支持硬件加速
 *
 *
 * memhash
 * Go语言内置的哈希表数据结构map，也是一个哈希结构，它内置的哈希算法更讲究。
 * 这里用到的哈希算法是memhash，源代码在runtime/hash32.go里面。它基于谷歌的两个哈希算法实现
 * xxhash: https://code.google.com/p/xxhash/
 * cityhash: https://code.google.com/p/cityhash/
 *
 *
 *
 * http://blog.cyeam.com/hash/2018/05/28/hash-method?hmsr=toutiao.io&utm_medium=toutiao.io&utm_source=toutiao.io
 *
 **/