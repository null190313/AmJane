package org.lxrookie.start.substance.services.component.kafka.impl;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.lxrookie.start.substance.services.component.kafka.KafkaComponentConsumerServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.MessageListener;

/**
 *------------------------------.
 * @name : KafkaComponentConsumerServices
 * @author : 沐惜
 * @createTime : 2018/11/30 12:28
 * @description : TODO
 * @Version : 1.0
 *------------------------------
 */
public class KafkaComponentConsumerServicesImpl implements KafkaComponentConsumerServices , MessageListener<String, String> {

    private Logger logger = LoggerFactory.getLogger(KafkaComponentConsumerServicesImpl.class);

    @Override
    public void onMessage(ConsumerRecord<String, String> record) {
        logger.info("=============kafkaConsumer开始消费=============");
        String topic = record.topic();
        String key = record.key();
        String value = record.value();
        long offset = record.offset();
        int partition = record.partition();
        logger.info("-------------topic:"+topic);
        logger.info("-------------value:"+value);
        logger.info("-------------key:"+key);
        logger.info("-------------offset:"+offset);
        logger.info("-------------partition:"+partition);
        logger.info("~~~~~~~~~~~~~kafkaConsumer消费结束~~~~~~~~~~~~~");
    }
}
