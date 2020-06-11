package com.bme.task.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * redis事件监听
 *
 * @author yutyi
 * @date 2020/06/09
 */
@Configuration
public class RedisListenerConfig {

    private static final Topic KEYEVENT_EXPIRED_TOPIC = new PatternTopic("__keyevent@0__:expired");
    private static final Topic KEYEVENT_SET_TOPIC = new PatternTopic("__keyevent@0__:hset");

    @Autowired
    @Qualifier("redisKeyExpirationListener")
    private MessageListener redisKeyExpirationListener;

    @Autowired
    @Qualifier("redisKeySetListener")
    private MessageListener redisKeySetListener;

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                            MessageListenerAdapter expireListenerAdapter, MessageListenerAdapter goOnlineListenerAdapter) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(expireListenerAdapter, KEYEVENT_EXPIRED_TOPIC);
        container.addMessageListener(goOnlineListenerAdapter, KEYEVENT_SET_TOPIC);
        return container;
    }

    @Bean
    MessageListenerAdapter expireListenerAdapter() {
        return new MessageListenerAdapter(redisKeyExpirationListener);
    }

    @Bean
    MessageListenerAdapter goOnlineListenerAdapter() {
        return new MessageListenerAdapter(redisKeySetListener);
    }
}
