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

        // 添加数据到缓冲区
        String s = "Java3y";
        byteBuffer.put(s.getBytes());

        System.out.println("put完之后-->limit--->" + byteBuffer.limit());
        System.out.println("put完之后-->position--->" + byteBuffer.position());
        System.out.println("put完之后-->capacity--->" + byteBuffer.capacity());
        System.out.println("put完之后-->mark--->" + byteBuffer.mark());

        System.out.println("--------------------------------");

        // 从缓冲区获取数据
        // flip 切换成读模式
        byteBuffer.flip();

        System.out.println("flip完之后-->limit--->" + byteBuffer.limit());
        System.out.println("flip完之后-->position--->" + byteBuffer.position());
        System.out.println("flip完之后-->capacity--->" + byteBuffer.capacity());
        System.out.println("flip完之后-->mark--->" + byteBuffer.mark());

        System.out.println("--------------------------------");

        // 切换成读模式就可以读取数据
        byte[] bytes = new byte[byteBuffer.limit()];
        // 读取数据到字节数组
        byteBuffer.get(bytes);
        // 输出数据
        System.out.println(new String(bytes, 0, bytes.length));

        System.out.println("get完之后-->limit--->" + byteBuffer.limit());
        System.out.println("get完之后-->position--->" + byteBuffer.position());
        System.out.println("get完之后-->capacity--->" + byteBuffer.capacity());
        System.out.println("get完之后-->mark--->" + byteBuffer.mark());

        System.out.println("--------------------------------");

        // 读完后还想写数据到缓冲区,则调用clear(清空缓冲区)
        byteBuffer.clear();

        System.out.println("clear完之后-->limit--->" + byteBuffer.limit());
        System.out.println("clear完之后-->position--->" + byteBuffer.position());
        System.out.println("clear完之后-->capacity--->" + byteBuffer.capacity());
        System.out.println("clear完之后-->mark--->" + byteBuffer.mark());
    }
}
