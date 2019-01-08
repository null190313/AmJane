package org.lxrookie.start.substance.services.obj.impl;/*
 *------------------------------.
 * @Name : LogRecordPathServicesImpl
 * @author : 沐惜
 * @createTime : 2018/11/26$ 20:57
 * @description : TODO
 * @Version : 1.0
 *------------------------------
 */

import org.lxrookie.start.substance.base.services.BaseServices;
import org.lxrookie.start.substance.dao.LogRecordPathDao;
import org.lxrookie.start.substance.entity.LogRecordPathEntity;
import org.lxrookie.start.substance.services.obj.LogRecordPathServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 *------------------------------.
 * @name : LogRecordPathServicesImpl
 * @author : 沐惜
 * @createTime : 2018/12/3 18:04
 * @description : TODO
 * @Version : 1.0
 *------------------------------
 */
@Service("logRecordPathServices")
public class LogRecordPathServicesImpl extends BaseServices<LogRecordPathEntity> implements LogRecordPathServices {
    @Autowired
    private LogRecordPathDao logRecordPathDao;

    @Override
    public List<LogRecordPathEntity> selectLogRecordPathListsByIds(List<LogRecordPathEntity> logRecordPathEntities) {
        return null;
    }

    @Override
    public void insertLogRecordPath(LogRecordPathEntity logRecordPathEntity) {
    }

    @Override
    public void closeLogRecordPath(LogRecordPathEntity logRecordPathEntity) {
    }
}
