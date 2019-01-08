package org.lxrookie.start.substance.services.obj.impl;

import org.lxrookie.start.substance.base.services.BaseServices;
import org.lxrookie.start.substance.dao.UserBaseDataDao;
import org.lxrookie.start.substance.entity.UserBaseDataEntity;
import org.lxrookie.start.substance.services.obj.UserBaseDataServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *------------------------------.
 * @name : UserBaseDataServicesImpl
 * @author : 沐惜
 * @createTime : 2019/1/7 20:38
 * @description : 用户基础数据量实现类
 * @Version : 1.0
 *------------------------------
 */
@Service("userBaseDataServices")
public class UserBaseDataServicesImpl extends BaseServices<UserBaseDataEntity> implements UserBaseDataServices {

    @Autowired
    private UserBaseDataDao userBaseDataDao;
    @Override
    public UserBaseDataEntity selectUserBaseDataEntityByUserId(String userId) {
        return ((UserBaseDataDao)userBaseDataDao).selectUserBaseDataEntityByUserId(userId);
    }
}
