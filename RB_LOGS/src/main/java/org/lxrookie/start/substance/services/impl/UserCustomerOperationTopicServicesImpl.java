package org.lxrookie.start.substance.services.impl;

import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.lxrookie.start.substance.constant.SysTopicTubeConstant;
import org.lxrookie.start.substance.entity.LogRecordEntity;
import org.lxrookie.start.substance.entity.LogTypeEntity;
import org.lxrookie.start.substance.entity.UserBaseMessageEntity;
import org.lxrookie.start.substance.services.UserCustomerOperationTopicServices;
import org.lxrookie.start.substance.services.component.kafka.KafkaComponentProducerServices;
import org.lxrookie.start.substance.services.logicalprocessing.MessagePhysicalServices;
import org.lxrookie.start.substance.services.obj.LogRecordServices;
import org.lxrookie.start.substance.services.obj.LogTypeServices;
import org.lxrookie.start.substance.services.obj.UserBaseMessageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *------------------------------.
 * @name : UserCustomerOperationTopicServicesImpl
 * @author : 沐惜
 * @createTime : 2018/12/3 9:41
 * @description : TODO
 * @Version : 1.0
 *------------------------------
 */
@Service("UserCustomerOperationTopicServices")
public class UserCustomerOperationTopicServicesImpl implements UserCustomerOperationTopicServices {

    @Autowired
    private KafkaComponentProducerServices kafkaComponentProducerServices;

    @Autowired
    private LogRecordServices logRecordServices;

    @Autowired
    private UserBaseMessageServices userBaseMessageServices;

    @Autowired
    private LogTypeServices logTypeServices;

    @Autowired
    private MessagePhysicalServices messagePhysicalServices;

    private Logger logger = Logger.getLogger(UserCustomerOperationTopicServicesImpl.class);

    @Override
    public String theUserLoginInToRegisterOperation(String logRecordEntityJson) {
        JSONObject jsonObject = JSONObject.fromObject(logRecordEntityJson);
        LogRecordEntity logRecordEntity = (LogRecordEntity) JSONObject.toBean(jsonObject,LogRecordEntity.class);
        UserBaseMessageEntity userBaseMessageEntity = userBaseMessageServices.selectUserBaseMessageById(logRecordEntity.getLogRecordOperationId());
        LogTypeEntity logTypeEntity = logTypeServices.selectLogTypeEntityByKey(logRecordEntity.getLogRecordTypeId());
        String topicName =  SysTopicTubeConstant.USER_CUSTOMER_OPERATION_TOPIC;
        //ifPartition是否使用partition
        String ifPartition = "1";
        //partitionNum个数
        Integer partitionNum = 1;
        //操作用户昵称 或 真实姓名
        String role = userBaseMessageEntity.getUserRealName() == "" ?  userBaseMessageEntity.getUserNickName() :  userBaseMessageEntity.getUserRealName();
        //定义返回消息状态Map
       String resultJSON = "";
        try {
            kafkaComponentProducerServices.sndMesForTemplate(topicName,logRecordEntity,ifPartition,partitionNum,role);
            //插入消息实体
            logRecordServices.insertLogRecordTheStack(logRecordEntityJson);
            //写入文本
            //TODO
            //返回kafka发送状态
            resultJSON = messagePhysicalServices.messagePhysicalReturnJosnSuccess(logRecordEntityJson,"success");
        }catch (Exception e){
            logger.info("消息模板发送失败,失败原因 :"+e);
            logger.info("消息JSON串: "+logRecordEntityJson);
            resultJSON = messagePhysicalServices.messagePhysicalReturnJosnSuccess(logRecordEntityJson,"error");
        }
        return resultJSON;
    }
}
