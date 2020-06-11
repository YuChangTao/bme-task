package com.bme.task.event;

import com.bme.task.common.RedisClientTemplate;
import com.bme.task.dao.tidb.EventChangeMapper;
import com.bme.task.service.EventChangeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.Map;

/**
 * Redis过期监听事件
 *
 * @author yutyi
 * @date 2020/06/09
 */
@Service("redisKeyExpirationListener")
public class RedisKeyExpirationListener implements MessageListener {

    private Logger logger = LoggerFactory.getLogger(RedisKeySetListener.class);
    private final static String keyPrefix = "upDown:status:";

    @Autowired
    private EventChangeService eventChangeService;

    @Autowired
    private RedisClientTemplate redisClientTemplate;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        //获取过期的key
        String expireKey = new String(message.getBody());
        if (expireKey.startsWith(keyPrefix)) {
            logger.info("expire:{},pattern:{}",expireKey,new String(pattern));
            String sn = expireKey.substring(keyPrefix.length());
            Map<Object, Object> map = redisClientTemplate.hGetAll("snInfo:bme:" + sn);
            if (!CollectionUtils.isEmpty(map)) {
                map.put("eventType",0);
                map.put("createTime",new Date());
                eventChangeService.insertEvent(map);
            } else {
                logger.warn("没有获取到该离线设备数据：{}",sn);
            }
        }
    }
}


