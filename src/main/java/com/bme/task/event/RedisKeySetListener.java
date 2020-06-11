package com.bme.task.event;

import com.bme.task.common.RedisClientTemplate;
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
 * 设备上线监听器
 *
 * @author yutyi
 * @date 2020/06/09
 */
@Service("redisKeySetListener")
public class RedisKeySetListener implements MessageListener {

    private Logger logger = LoggerFactory.getLogger(RedisKeySetListener.class);

    private final static String keyPrefix = "upDown:status:";

    @Autowired
    private EventChangeService eventChangeService;

    @Autowired
    private RedisClientTemplate redisClientTemplate;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        //获取上线设备的key
        String updateKey = new String(message.getBody());
        if (updateKey.startsWith(keyPrefix)) {
            logger.info("goOnline:{},pattern:{}", updateKey, new String(pattern));
            String sn = updateKey.substring(keyPrefix.length());
            Map<Object, Object> map = redisClientTemplate.hGetAll("snInfo:bme:" + sn);
            if (!CollectionUtils.isEmpty(map)) {
                map.put("eventType",1);
                map.put("createTime",new Date());
                eventChangeService.insertEvent(map);
            } else {
                logger.warn("没有获取到该上线设备数据：{}",sn);
            }
        }
    }
}
