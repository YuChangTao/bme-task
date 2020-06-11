package com.bme.task.service;

import java.util.Map;

/**
 * 事件
 *
 * @author yutyi
 * @date 2020/06/11
 */
public interface EventChangeService {

    /**
     * 插入事件
     * @param map
     * @return
     */
    boolean insertEvent(Map<Object,Object> map);
}
