package org.lxrookie.start.substance.services.obj.impl;

import org.lxrookie.start.substance.base.services.BaseServices;
import org.lxrookie.start.substance.dao.UserBaseMessageDao;
import org.lxrookie.start.substance.entity.UserBaseMessageEntity;
import org.lxrookie.start.substance.services.obj.UserBaseMessageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userBaseMessageServices")
public class UserBaseMessageServicesImpl extends BaseServices<UserBaseMessageEntity> implements UserBaseMessageServices {


    @Autowired
    private UserBaseMessageDao userBaseMessageDao;



    @Override
    public UserBaseMessageEntity selectUserBaseMessageById(String userId) {
        return ((UserBaseMessageDao)getMapper()).selectByPrimaryKey(userId);
    }
}
