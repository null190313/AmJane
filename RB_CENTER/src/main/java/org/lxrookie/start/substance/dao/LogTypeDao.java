package org.lxrookie.start.substance.dao;

import org.apache.ibatis.annotations.Param;
import org.lxrookie.start.substance.base.dao.BaseDao;
import org.lxrookie.start.substance.entity.LogTypeEntity;
import org.springframework.stereotype.Component;

/**
 *------------------------------.
 * @name : LogTypeDao
 * @author : 沐惜
 * @createTime : 2018/12/2 18:04
 * @description : TODO
 * @Version : 1.0
 *------------------------------
 */
@Component
public interface LogTypeDao extends BaseDao<LogTypeEntity> {
        public LogTypeEntity selectLogTypeEntityByKey(@Param("key") String key);
}
