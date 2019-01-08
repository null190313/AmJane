package org.lxrookie.start.substance.services.component.kafka;

import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.Map;

/**
 *------------------------------.
 * @name : KafkaComponentProducerServices
 * @创建人 : 沐惜
 * @创建时间 : 2018/11/30 13:07
 * @方法描述 : TODO
 * @Version : 1.0
 *------------------------------
 */

public interface KafkaComponentProducerServices {

    /**
     *------------------------------.
     * @name : sndMesForTemplate
     * @author : 沐惜
     * @Param : topic 主题
     * @Param : value messageValue
     * @Param : ifPartition 是否使用分区 0是\1不是
     * @Param : partitionNum 分区数 如果是否使用分区为0,分区数必须大于0
     * @Param : role 角色
     * @Return :
     * @createTime : 2018/11/30 13:08
     * @description : TODO
     * @Version : 1.0
     *------------------------------
     */
    public Map<String,Object> sndMesForTemplate(String topic, Object value, String ifPartition,
                                                Integer partitionNum, String role);

    /**
     *------------------------------.
     * @name : KafkaComponentProducerServices
     * @author : 沐惜
     * @Param : key
     * @Param : key
     * @Return : partitionNum
     * @createTime : 2018/11/30 13:09
     * @description : TODO
     * @Version : 1.0
     *------------------------------
     */
    public int getPartitionIndex(String key, int partitionNum);

    /**
     *------------------------------.
     * @name : KafkaComponentProducerServices
     * @author : 沐惜
     * @Param : res
     * @Return :  record
     * @createTime : 2018/11/30 13:10
     * @description : TODO
     * @Version : 1.0
     *------------------------------
     */
    public Map<String,Object> checkProRecord(ListenableFuture<SendResult<String, String>> res);
}
