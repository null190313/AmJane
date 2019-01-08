package org.lxrookie.start.substance.services.logicalprocessing.impl;

import net.sf.json.JSONObject;
import org.lxrookie.start.substance.entity.LogRecordEntity;
import org.lxrookie.start.substance.entity.LogTypeEntity;
import org.lxrookie.start.substance.services.logicalprocessing.MessagePhysicalServices;
import org.lxrookie.start.substance.services.obj.LogTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 *------------------------------.
 * @name : MessagePhysicalServicesImpl
 * @author : 沐惜
 * @createTime : 2018/12/3 16:55
 * @description : TODO
 * @Version : 1.0
 *------------------------------
 */
@Service("messagePhysicalServices")
public class MessagePhysicalServicesImpl implements MessagePhysicalServices {

    @Autowired
    private LogTypeServices logTypeServices;

    @Override
    public String messagePhysicalReturnJosnSuccess(String logRecordEntityJSON,String resultState){
        JSONObject jsonObject = JSONObject.fromObject(logRecordEntityJSON);
        LogRecordEntity logRecordEntity = (LogRecordEntity) JSONObject.toBean(jsonObject);
        Map<String,String> map = new HashMap<String,String>();
        LogTypeEntity logTypeEntity = logTypeServices.selectLogTypeEntityByKey(logRecordEntity.getLogRecordTypeId());
        map.put("result",resultState);
        map.put("status",logTypeEntity.getLogTypeOperationCode());
        map.put("directory",logTypeEntity.getLogTypeDirectory());
        map.put("directoryDescript",logTypeEntity.getLogTypeDirectoryDescribe());
        JSONObject resultJSONState = JSONObject.fromObject(map);
        return resultState;
    }

}
