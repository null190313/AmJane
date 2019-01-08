package org.lxrookie.start.substance.dao;

import org.apache.ibatis.annotations.Param;
import org.lxrookie.start.substance.base.dao.BaseDao;
import org.lxrookie.start.substance.entity.UserBaseDataEntity;
import org.springframework.stereotype.Component;

/**
 *------------------------------.
 * @name : UserBaseDataDao
 * @author : 沐惜
 * @createTime : 2019/1/7 20:35
 * @description : 用户基础数据量
 * @Version : 1.0
 *------------------------------
 */
@Component
public interface UserBaseDataDao extends BaseDao<UserBaseDataEntity> {

    /**
     *------------------------------.
     * @name : UserBaseDataDao
     * @author : 沐惜
     * @createTime : 2019/1/7 21:57
     * @description : 根据UserId查询
     * @Version : 1.0
     *------------------------------
     */
    public UserBaseDataEntity selectUserBaseDataEntityByUserId(@Param("userId") String userId);
}
