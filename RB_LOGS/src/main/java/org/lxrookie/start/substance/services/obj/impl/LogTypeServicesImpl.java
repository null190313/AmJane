package org.lxrookie.start.substance.services.obj.impl;

import org.lxrookie.start.substance.base.services.BaseServices;
import org.lxrookie.start.substance.dao.LogRecordDao;
import org.lxrookie.start.substance.dao.LogTypeDao;
import org.lxrookie.start.substance.entity.LogTypeEntity;
import org.lxrookie.start.substance.services.obj.LogTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 *------------------------------.
 * @name : LogTypeServicesImpl
 * @author : 沐惜
 * @createTime : 2018/11/30 14:53
 * @description : TODO
 * @Version : 1.0
 *------------------------------
 */
@Service("logTypeServices")
public class LogTypeServicesImpl extends BaseServices<LogTypeEntity> implements LogTypeServices {

    @Autowired
    private LogTypeDao logTypeDao;
    @Override
    public List<LogTypeEntity> selectLogTypeListsByIds(List<LogTypeEntity> logTypeEntities) {
            return null;
    }

    @Override
    public LogTypeEntity selectLogTypeEntityByKey(String key) {
        return ((LogTypeDao)logTypeDao).selectByPrimaryKey(key);
    }

    @Override
    public void insertLogType(LogTypeEntity logTypeEntity) {
        ((LogTypeDao)logTypeDao).insert(logTypeEntity);
    }

    @Override
    public void closeLogType(LogTypeEntity logTypeEntity) {
    }
}
