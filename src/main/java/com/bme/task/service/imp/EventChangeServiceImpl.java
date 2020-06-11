package com.bme.task.service.imp;

import com.bme.task.dao.tidb.EventChangeMapper;
import com.bme.task.service.EventChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author yutyi
 * @date 2020/06/11
 */
@Service
public class EventChangeServiceImpl implements EventChangeService {

    @Autowired
    private EventChangeMapper eventChangeMapper;

    @Override
    public boolean insertEvent(Map<Object, Object> map) {
        Integer count = eventChangeMapper.insert(map);
        return count > 0 ? true : false;
    }
}
