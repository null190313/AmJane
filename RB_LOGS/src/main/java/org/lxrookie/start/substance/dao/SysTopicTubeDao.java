package org.lxrookie.start.substance.dao;

import org.apache.ibatis.annotations.Param;
import org.lxrookie.start.substance.base.dao.BaseDao;
import org.lxrookie.start.substance.entity.SysTopicTubeEntity;
import org.springframework.stereotype.Component;

/**
 *------------------------------.
 * @name : SysTopicTubeDao
 * @author : 沐惜
 * @createTime : 2018/11/30 19:08
 * @description : TODO
 * @Version : 1.0
 *------------------------------
 */
@Component
public interface SysTopicTubeDao  extends BaseDao<SysTopicTubeEntity> {

    /**
     *------------------------------.
     * @name : SysTopicTubeDao
     * @author : 沐惜
     * @Param :key topicKey
     * @Return : SysTopicTubeEntity
     * @createTime : 2018/12/1 9:38
     * @description : 根据Key获取SysTopic
     * @Version : 1.0
     *------------------------------
     */
    public SysTopicTubeEntity selectSysTopicTubeEntity(@Param("key") String key);
}
