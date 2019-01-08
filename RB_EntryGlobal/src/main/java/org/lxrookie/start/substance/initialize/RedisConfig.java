package org.lxrookie.start.substance.initialize;


import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
  *------------------------------.
  *@ClassName : RedisConfig
  *@author : 沐惜
  *@createTime : 2018/11/16 16:33
  *@描述 : TODO
  *@Version : 1.0
  *------------------------------
  */
@Configuration
@PropertySource(value = { "classpath:spring/redis/redis.properties" })
public class RedisConfig {
    /**
     * 日志管理
     */
    private Logger logger = Logger.getLogger(RedisConfig.class);

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.database}")
    private int database;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.timeout}")
    private int timeout;

    @Value("${spring.redis.pool.max-active}")
    private int maxActive;

    @Value("${spring.redis.pool.max-wait}")
    private int maxWait;

    @Value("${spring.redis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.pool.min-idle}")
    private int minIdle;

    /**
    *------------------------------.
    *@MethodName : getJedisPool
    *@author : 沐惜
    *@createTime : 2018/11/16 16:35
    *@description :  获取jedisPool
    *@param :
     *@return :
    *@Version : 1.0
    *------------------------------
    */
    @Bean
    public JedisPool getJedisPool() {
        logger.info("=========================================>初始化jedis连接池");
        JedisPoolConfig config = new JedisPoolConfig();
        JedisPool pool = new JedisPool(config, host, port,timeout);
        return pool;
    }
}
