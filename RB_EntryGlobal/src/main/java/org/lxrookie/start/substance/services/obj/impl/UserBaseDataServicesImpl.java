package org.lxrookie.start.substance.services.obj.impl;

import org.lxrookie.start.substance.base.services.BaseServices;
import org.lxrookie.start.substance.dao.UserBaseDataDao;
import org.lxrookie.start.substance.entity.UserBaseDataEntity;
import org.lxrookie.start.substance.services.obj.UserBaseDataServices;
import org.lxrookie.start.substance.util.DateUtils;
import org.lxrookie.start.substance.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ------------------------------.
 *
 * @author : 沐惜
 * @name : UserBaseDataServicesImpl
 * @createTime : 2019/1/7 20:38
 * @description : 用户基础数据量实现类
 * @Version : 1.0
 * ------------------------------
 */
@Service("userBaseDataServices")
public class UserBaseDataServicesImpl extends BaseServices<UserBaseDataEntity> implements UserBaseDataServices {

    @Autowired
    private UserBaseDataDao userBaseDataDao;

    /**
     * ------------------------------.
     *
     * @name : UserBaseDataServicesImpl
     * @author : 沐惜
     * @createTime : 2019/1/7 20:45
     * @description : 注册基础插入
     * @Version : 1.0
     * ------------------------------
     */
    @Override
    public void insertUserBaseDataOfId(String userId) {
        UserBaseDataEntity userBaseDataEntity = new UserBaseDataEntity();
        userBaseDataEntity.setUserDataId(UUIDUtils.uuid());
        userBaseDataEntity.setUserMessageId(userId);
        userBaseDataEntity.setUserMessageBlog(0);
        userBaseDataEntity.setUserMessageFans(0);
        userBaseDataEntity.setUserMessageFocus(0);
        userBaseDataEntity.setUserMessageShared(0);
        userBaseDataEntity.setUserMessageStorage(0.00);
        userBaseDataEntity.setUserMessageAlterTime(DateUtils.tranDate());
        ((UserBaseDataDao) getMapper()).insert(userBaseDataEntity);
    }


}
