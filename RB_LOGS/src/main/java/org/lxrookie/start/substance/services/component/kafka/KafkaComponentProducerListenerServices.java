package org.lxrookie.start.substance.services.component.kafka;

import org.apache.kafka.clients.producer.RecordMetadata;

/**
 *------------------------------.
 * @name : KafkaComponentProducerServices
 * @author : 沐惜
 * @createTime : 2018/11/30 13:01
 * @description : TODO
 * @Version : 1.0
 *------------------------------
 */
public interface KafkaComponentProducerListenerServices {
    /**
     *------------------------------.
     * @name : onSuccess
     * @author : 沐惜
     * @Param : topic : topic
     * @Param : partition:区间
     * @Param : key：消息key
     * @Param : value:消息实体
     * @Return :
     * @createTime : 2018/11/30 13:01
     * @description : 发送消息成功后调用
     * @Version : 1.0
     *------------------------------
     */
    public void onSuccess(String topic, Integer partition, Object key, Object value, RecordMetadata recordMetadata);

    /**
     *------------------------------.
     * @name : KafkaComponentProducerServices
     * @author : 沐惜
     * @Param : topic : topic
     * @Param : partition:区间
     * @Param : key：消息key
     * @Param : value:消息实体
     * @Return : 
     * @createTime : 2018/11/30 13:02
     * @description : 发送消息错误后调用
     * @Version : 1.0
     *------------------------------
     */
    public void onError(String topic, Integer partition, Object key, Object value, Exception exception);

    /**
     *------------------------------.
     * @name : KafkaComponentProducerServices
     * @author : 沐惜
     * @Param :
     * @Return :
     * @createTime : 2018/11/30 13:02
     * @description :  方法返回值代表是否启动kafkaProducer监听器
     * @Version : 1.0
     *------------------------------
     */
    public boolean isInterestedInSuccess();


}
