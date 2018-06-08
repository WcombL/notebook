package com.zrkj.client;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

public class JavaClient {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();

        // 消费者线程池
//        ExecutorService es = Executors.newFixedThreadPool(20);
//        Connection connection = factory.newConnection(es);

        // channel 可以用来收和发消息
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("logs", BuiltinExchangeType.FANOUT);

        String message = "Hello world";
        channel.basicPublish("logs", "", null, message.getBytes());

        // 随机队列名称
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName,"logs","");
    }
}
