package org.lxrookie.start.substance.services.component.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;

/**
 *------------------------------.
 * @name : KafkaComponentConsumerServices
 * @author : 沐惜
 * @createTime : 2018/11/30 12:28
 * @description : TODO
 * @Version : 1.0
 *------------------------------
 */
public interface KafkaComponentConsumerServices {

    public void onMessage(ConsumerRecord<String, String> record);
}
