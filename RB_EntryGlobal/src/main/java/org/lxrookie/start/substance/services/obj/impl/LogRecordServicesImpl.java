package org.lxrookie.start.substance.services.obj.impl;

import net.sf.json.JSONObject;
import org.lxrookie.start.substance.base.services.BaseServices;
import org.lxrookie.start.substance.dao.LogRecordDao;
import org.lxrookie.start.substance.entity.LogRecordEntity;
import org.lxrookie.start.substance.services.obj.LogRecordServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
*------------------------------.
* @MethodName : LogRecordServicesImpl
* @author : 沐惜
* @createTime : 2018/11/26 20:54
* @description : TODO
* @Version : 1.0
*------------------------------
*/
@Service("logRecordServices")
public class LogRecordServicesImpl extends BaseServices<LogRecordEntity> implements LogRecordServices {

    @Autowired
    private LogRecordDao logRecordDao;

    @Override
    public LogRecordEntity selectLogRecordListsById(String id) {
        return ((LogRecordDao)getMapper()).selectByPrimaryKey(id);
    }

    @Override
    public void insertLogRecord(LogRecordEntity logRecordEntity) {
         ((LogRecordDao)getMapper()).insert(logRecordEntity);
    }

    @Override
    public void closeLogRecord(LogRecordEntity logRecordEntity) {
    }

    @Override
    public void insertLogRecordTheStack(String logRecordEntityJSON) {
        JSONObject jsonObject = JSONObject.fromObject(logRecordEntityJSON);
        LogRecordEntity logRecordEntity = (LogRecordEntity) JSONObject.toBean(jsonObject);
        ((LogRecordDao)getMapper()).insert(logRecordEntity);
    }
}
