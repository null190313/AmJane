package org.lxrookie.start.substance.services.component.kafka.impl;


import org.apache.kafka.clients.producer.RecordMetadata;
import org.lxrookie.start.substance.services.component.kafka.KafkaComponentProducerListenerServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Service;

/**
 *------------------------------.
 * @name : KafkaComponentProducerServicesImpl
 * @author : 沐惜
 * @createTime : 2018/11/30 13:04
 * @description : TODO
 * @Version : 1.0
 *------------------------------
 */
@SuppressWarnings("rawtypes")
@Service("kafkaComponentProducerListenerServices")
public class KafkaComponentProducerListenerServicesImpl implements KafkaComponentProducerListenerServices , ProducerListener {

    private Logger logger = LoggerFactory.getLogger(KafkaComponentProducerListenerServicesImpl.class);

    @Override
    public void onSuccess(String topic, Integer partition, Object key, Object value, RecordMetadata recordMetadata) {
        logger.info("==========kafka发送数据成功（日志开始）==========");
        logger.info("----------topic:"+topic);
        logger.info("----------partition:"+partition);
        logger.info("----------key:"+key);
        logger.info("----------value:"+value);
        logger.info("----------RecordMetadata:"+recordMetadata);
        logger.info("~~~~~~~~~~kafka发送数据成功（日志结束）~~~~~~~~~~");
    }

    @Override
    public void onError(String topic, Integer partition, Object key, Object value, Exception exception) {
        logger.info("==========kafka发送数据错误（日志开始）==========");
        logger.info("----------topic:"+topic);
        logger.info("----------partition:"+partition);
        logger.info("----------key:"+key);
        logger.info("----------value:"+value);
        logger.info("----------Exception:"+exception);
        logger.info("~~~~~~~~~~kafka发送数据错误（日志结束）~~~~~~~~~~");
        exception.printStackTrace();
    }

    @Override
    public boolean isInterestedInSuccess() {
        logger.info("///kafkaProducer监听器启动///");
        return true;
    }
}
