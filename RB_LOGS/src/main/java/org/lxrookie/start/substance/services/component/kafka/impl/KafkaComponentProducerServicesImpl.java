package org.lxrookie.start.substance.services.component.kafka.impl;

import com.alibaba.fastjson.JSON;
import org.lxrookie.start.substance.services.component.kafka.KafkaComponentProducerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutionException;

@Service("kafkaComponentProducerServices")
public class KafkaComponentProducerServicesImpl implements KafkaComponentProducerServices {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * kafka发送消息模板
     * @param topic 主题
     * @param value    messageValue
     * @param ifPartition 是否使用分区 0是\1不是
     * @param partitionNum 分区数 如果是否使用分区为0,分区数必须大于0
     * @param role 角色:bbc app erp...
     */
    @Override
    public Map<String,Object> sndMesForTemplate(String topic, Object value, String ifPartition,
                                                Integer partitionNum, String role) {
        String key = role + "-" + value.hashCode();
        String valueString = JSON.toJSONString(value);
        if ("0".equals(ifPartition)) {
            //表示使用分区
            int partitionIndex = getPartitionIndex(key, partitionNum);
            ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send(topic, partitionIndex, key, valueString);
            Map<String, Object> res = checkProRecord(result);
            return res;
        } else {
            ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send(topic, key, valueString);
            Map<String, Object> res = checkProRecord(result);
            return res;
        }
    }

    @Override
    public int getPartitionIndex(String key, int partitionNum) {
        if (key == null) {
            Random random = new Random();
            return random.nextInt(partitionNum);
        }
        else {
            int result = Math.abs(key.hashCode())%partitionNum;
            return result;
        }
    }

    @Override
    public Map<String, Object> checkProRecord(ListenableFuture<SendResult<String, String>> res) {
        Map<String,Object> m = new HashMap<String,Object>();
        if(res!=null){
            try {
                //检查result结果集
                SendResult r = res.get();
                /*检查recordMetadata的offset数据，不检查producerRecord*/
                Long offsetIndex = r.getRecordMetadata().offset();
                if(offsetIndex!=null && offsetIndex>=0){
                    m.put("code","0001");
                    m.put("message", "SUCCESS_MES");
                    return m;
                }else{
                    m.put("code", "0002");
                    m.put("message", "KAFKA_NO_OFFSET_MES");
                    return m;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                m.put("code", "0003");
                m.put("message", "KAFKA_SEND_ERROR_MES");
                return m;
            } catch (ExecutionException e) {
                e.printStackTrace();
                m.put("code", "0003");
                m.put("message","KAFKA_SEND_ERROR_MES");
                return m;
            }
        }else{
            m.put("code", "0004");
            m.put("message", "KAFKA_NO_RESULT_MES");
            return m;
        }
    }


}
