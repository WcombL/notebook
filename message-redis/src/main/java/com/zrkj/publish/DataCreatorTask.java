package com.zrkj.publish;

import com.zrkj.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Random;

/**
 * 基于RedisTemplate 的序列化方式
 */
public class DataCreatorTask {

    private final static Logger LOG = LoggerFactory.getLogger(DataCreatorTask.class);

    @Autowired
    private RedisTemplate redisTemplate;
    Random random = new Random(100);

    // 每5秒发送一个消息
    @Scheduled(cron = "*/5 * * * * ?")
    public void redisDataPublishTask() {
        User user = new User(
                random.nextInt(100),
                "zhang" + random.nextInt(),
                "zhang@cincout.cn"
        );
        //redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<User>(User.class));
        redisTemplate.convertAndSend("pinpoint.collector.channel", user);
        LOG.info("send user {} to redis channel.", user.toString());
    }
}
