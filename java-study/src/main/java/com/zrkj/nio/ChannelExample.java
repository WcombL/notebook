package com.zrkj.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;

public class ChannelExample {

    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\work\\2018\\idea\\spring-guides\\notebook\\Java\\NIO.md");
            // 获取文件输入管道
            FileChannel fileChannel = fileInputStream.getChannel();

            // 1.7之后
            FileChannel fileChannel1 = FileChannel.open(Paths.get("C:\\work\\2018\\idea\\spring-guides\\notebook\\Java\\NIO.md"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
