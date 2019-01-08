package org.lxrookie.start.substance.constant;

import org.lxrookie.start.substance.initialize.ConfigurationFileRead;
/**
 *------------------------------.
 * @name : ConfigStaticAttribute
 * @author : 沐惜
 * @createTime : 2018/11/30 12:31
 * @description : 配置文件初始化获取
 * @Version : 1.0
 *------------------------------
 */
public class ConfigStaticAttribute {

    /**
     * kafka host
     */
    public static final String KAFKA_HOST = ConfigurationFileRead.getCOnfigValueByKey("kafka.host");

    /**
     * kafka port
     */
    public static final String KAFKA_PORT = ConfigurationFileRead.getCOnfigValueByKey("kafka.port");

    /**
     * kafka topic-name
     */
    public static final String KAFKA_TOPIC_NAME = ConfigurationFileRead.getCOnfigValueByKey("kafka.topic.name");

    /**
     * redis host
     */
    public static final String REDIS_HOST = ConfigurationFileRead.getCOnfigValueByKey("spring.redis.host");

    /**
     * redis port
     */
    public static final String REDIS_PORT = ConfigurationFileRead.getCOnfigValueByKey("spring.redis.port");






}
