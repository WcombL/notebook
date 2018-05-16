package com.zrkj.nio;

import java.nio.ByteBuffer;

/**
 * Buffer 代码示例
 */
public class BufferExample {

    public static void main(String[] args) {
        // 创建Buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // 四个核心变量值
        System.out.println("初始时-->limit--->" + byteBuffer.limit());
        System.out.println("初始时-->position--->" + byteBuffer.position());
        System.out.println("初始时-->capacity--->" + byteBuffer.capacity());
        System.out.println("初始时-->mark--->" + byteBuffer.mark());

        System.out.println("--------------------------------");
    }
}
