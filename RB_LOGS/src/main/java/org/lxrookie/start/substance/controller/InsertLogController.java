package org.lxrookie.start.substance.controller;

import net.sf.json.JSONObject;
import org.lxrookie.start.substance.constant.SysTopicTubeConstant;
import org.lxrookie.start.substance.entity.LogTypeEntity;
import org.lxrookie.start.substance.entity.SysTopicTubeEntity;
import org.lxrookie.start.substance.services.component.kafka.KafkaComponentProducerServices;
import org.lxrookie.start.substance.services.obj.LogRecordServices;
import org.lxrookie.start.substance.services.obj.LogTypeServices;
import org.lxrookie.start.substance.services.obj.SysTopicTubeServices;
import org.lxrookie.start.substance.util.UUIDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

/**
 *------------------------------.
 * @MethodName : InsertLogController
 * @author : 沐惜
 * @createTime : 2018/11/26 20:51
 * @description : TODO
 * @Version : 1.0
 *------------------------------
 */
@Controller
public class InsertLogController  {
    private static final Logger logger = LoggerFactory.getLogger(InsertLogController.class);
    @Autowired
    private KafkaComponentProducerServices kafkaComponentProducerServices;

    @Autowired
    private LogTypeServices logTypeServices;

    @Autowired
    private LogRecordServices logRecordServices;

    @RequestMapping(value = "testKafka.html")
    public  void assignPartitionByKey() throws Exception {
        String topic = "USER_CUSTOMER_OPERATION_TOPIC";
        String value = "test";
        String ifPartition = "1";
        Integer partitionNum = 1;
        //用来生成key
        String role = "test";
        Map<String,Object> res = kafkaComponentProducerServices.sndMesForTemplate
                (topic, value, ifPartition, partitionNum, role);

        System.out.println("测试结果如下：===============");
        String message = (String)res.get("message");
        String code = (String)res.get("code");

        System.out.println("code:"+code);
        System.out.println("message:"+message);
    }

    @RequestMapping(value = "insertLogType.html")
    public String insertLogType(LogTypeEntity logTypeEntity){
        logTypeEntity.setLogTypeId(UUIDUtils.uuid());
        logTypeEntity.setLogTypeState(0);
        logTypeEntity.setLogTypeCreateTime(new Date());
        logTypeServices.insertLogType(logTypeEntity);
        return "redirect:hello.html";
    }

    @RequestMapping(value = "hello.html")
    public String hello(){
        return "/logType";
    }


    @RequestMapping(value = "insertLogRecord.html")
    public void insertLogRecord(){
        /*LogRecordEntity logRecordEntity = new LogRecordEntity();
        logRecordEntity.setLogRecordOperationId("用户ID");
        logRecordEntity.setLogRecordSystemName("RB_EntryGlobal");
        logRecordEntity.setLogRecordOperation("SELECT");
        logRecordEntity.setLogRecordSysUser(0);
        logRecordEntity.setLogRecordId(UUIDUtils.uuid());
        logRecordEntity.setLogRecordTypeId("a8fb51512a754b189d20427b6cd740af");
        logRecordEntity.setLogRecordComment("kafka日志json实体操作");
        logRecordEntity.setLogRecordLevel("INFO");
        logRecordEntity.setLogRecordCreateTime(new Date());
        logRecordEntity.setLogRecordState(0);
        logRecordEntity.setLogRecordClient(0);
        logRecordEntity.setLogRecordOutPutFilepathId("日志输出文件路径ID");
        logRecordServices.insertLogRecord(logRecordEntity);*/
        JSONObject jsonObject = JSONObject.fromObject(logRecordServices.selectLogRecordListsById("da79373dff554d858a7cc042eaaae4f4"));
        System.err.println(jsonObject);
    }

    @Autowired
    private SysTopicTubeServices sysTopicTubeServices;


    @RequestMapping(value = "insertSysTopic.html")
    public void insertSysToic(){
        SysTopicTubeEntity sysTopicTubeEntity = new SysTopicTubeEntity();
        sysTopicTubeEntity.setSysTopicTubeId(UUIDUtils.uuid());
        sysTopicTubeEntity.setSysTopicTubeKey("USER_CUSTOMER_OPERATION_TOPIC");
        sysTopicTubeEntity.setSysTopicTubeValue("USER_CUSTOMER_OPERATION_TOPIC");
        sysTopicTubeEntity.setSysTopicTubeStatus(0);
        sysTopicTubeEntity.setSysTopicTubeCreateTime(new Date());
        sysTopicTubeEntity.setSysTopicTubeDescription("用户基础操作topic   基础操作部分:登录 退出 个人信息操作");
        sysTopicTubeServices.insertSysTopicTubeEntity(sysTopicTubeEntity);

    }


    @RequestMapping(value = "testTopic.html")
    public void testTopic(){
        String topic = SysTopicTubeConstant.USER_CUSTOMER_OPERATION_TOPIC;
        System.out.println(topic);
    }

}
