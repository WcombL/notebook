package com.zrkj.algorithm.hash;

import java.math.BigInteger;

/**
 * FNA Hash 算法
 * <p>
 * 算法描述：
 * 相关变量：
 * hash值：一个n位的unsigned int型hash值
 * offset_basis：初始的哈希值
 * FNV_prime：FNV用于散列的质数
 * octet_of_data：8位数据（即一个字节）
 * <p>
 * FNV-1描述：
 * hash = offset_basis
 * for each octet_of_data to be hashed
 * hash = hash * FNV_prime
 * hash = hash xor octet_of_data
 * return hash
 * <p>
 * FNV-1a描述：
 * hash = offset_basis
 * for each octet_of_data to be hashed
 * hash = hash xor octet_of_data
 * hash = hash * FNV_prime
 * return hash
 * <p>
 * FNV_prime的取值:
 * 32 bit FNV_prime = 2^24 + 2^8 + 0x93 = 16777619
 * 64 bit FNV_prime = 2^40 + 2^8 + 0xb3 = 1099511628211
 * 128 bit FNV_prime = 2^88 + 2^8 + 0x3b = 309485009821345068724781371
 * 256 bit FNV_prime = 2^168 + 2^8 + 0x63 =374144419156711147060143317175368453031918731002211
 * 512 bit FNV_prime = 2^344 + 2^8 + 0x57 = 35835915874844867368919076489095108449946327955754392558399825615420669938882575126094039892345713852759
 * 1024 bit FNV_prime = 2^680 + 2^8 + 0x8d =5016456510113118655434598811035278955030765345404790744303017523831112055108147451509157692220295382716162651878526895249385292291816524375083746691371804094271873160484737966720260389217684476157468082573
 * <p>
 * offset_basis的取值:
 * 32 bit offset_basis = 2166136261
 * 64 bit offset_basis = 14695981039346656037
 * 128 bit offset_basis = 144066263297769815596495629667062367629
 * 256 bit offset_basis = 100029257958052580907070968620625704837092796014241193945225284501741471925557
 * 512 bit offset_basis = 9659303129496669498009435400716310466090418745672637896108374329434462657994582932197716438449813051892206539805784495328239340083876191928701583869517785
 * 1024 bit offset_basis = 14197795064947621068722070641403218320880622795441933960878474914617582723252296732303717722150864096521202355549365628174669108571814760471015076148029755969804077320157692458563003215304957150157403644460363550505412711285966361610267868082893823963790439336411086884584107735010676915
 * <p>
 * http://www.isthe.com/chongo/tech/comp/fnv/index.html#FNV-param
 */
public class FNAHash {

    // 初始Hash值
    private static final BigInteger INIT32 = new BigInteger("811c9dc5", 16);
    private static final BigInteger INIT64 = new BigInteger("cbf29ce484222325", 16);
    // 散列质数
    private static final BigInteger PRIME32 = new BigInteger("01000193", 16);
    private static final BigInteger PRIME64 = new BigInteger("100000001b3", 16);

    private static final BigInteger MOD32 = new BigInteger("2").pow(32);
    private static final BigInteger MOD64 = new BigInteger("2").pow(64);

    public BigInteger fnv1_32(byte[] data) {
        BigInteger hash = INIT32;
        for (byte b : data) {
            hash = hash.multiply(PRIME32).mod(MOD32);
            hash = hash.xor(BigInteger.valueOf((int) b & 0xff));
        }
        return hash;
    }

    public BigInteger fnv1_64(byte[] data) {
        BigInteger hash = INIT64;
        for (byte b : data) {
            hash = hash.multiply(PRIME64).mod(MOD64);
            hash = hash.xor(BigInteger.valueOf((int) b & 0xff));
        }
        return hash;
    }

    public BigInteger fnv1a_32(byte[] data) {
        BigInteger hash = INIT32;
        for (byte b : data) {
            hash = hash.xor(BigInteger.valueOf((int) b & 0xff));
            hash = hash.multiply(PRIME32).mod(MOD32);
        }
        return hash;
    }

    public BigInteger fnv1a_64(byte[] data) {
        BigInteger hash = INIT64;
        for (byte b : data) {
            hash = hash.xor(BigInteger.valueOf((int) b & 0xff));
            hash = hash.multiply(PRIME64).mod(MOD64);
        }
        return hash;
    }
}
