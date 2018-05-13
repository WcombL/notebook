package com.zrkj;


import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.api.sync.RedisCommands;

import java.util.function.Consumer;

public class RedisClientTest {

    public static void main(String[] args) {
//        generalClientSync();
        generalClientAsync();
    }


    /**
     * 普通连接 - 同步
     */
    public static void generalClientSync(){
        RedisClient redisClient = RedisClient.create("redis://localhost:6379/0");
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisCommands<String, String> syncCommands = connection.sync();

        syncCommands.set("key", "Hello, Redis!");
        // 使用阻塞的方式读取
        System.out.println(syncCommands.get("key"));

        connection.close();
        redisClient.shutdown();
    }

    /**
     * 普通连接 - 异步
     */
    public static void generalClientAsync(){
        RedisClient redisClient = RedisClient.create("redis://localhost:6379/0");
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisAsyncCommands<String, String> asyncCommands = connection.async();

        asyncCommands.set("key", "Hello, Redis!");
        // 异步方式，当 RedisFuture<T>是完成状态时自动触发后面的动作
        RedisFuture<String> future =  asyncCommands.get("key");
        future.thenAccept((value)-> System.out.println(value));

        connection.close();
        redisClient.shutdown();
    }
}
