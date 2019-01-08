package org.lxrookie.start.substance.services.component.kafka.impl;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.lxrookie.start.substance.services.component.kafka.KafkaComponentConsumerAckListenerServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;
/**
 *------------------------------.
 * @name : KafkaComponentConsumerAckListenerServicesImpl
 * @author : 沐惜
 * @createTime : 2018/11/30 12:25
 * @description : TODO
 * @Version : 1.0
 *------------------------------
 */
public class KafkaComponentConsumerAckListenerServicesImpl implements KafkaComponentConsumerAckListenerServices {
    private Logger logger = LoggerFactory.getLogger(KafkaComponentConsumerAckListenerServicesImpl.class);

}
