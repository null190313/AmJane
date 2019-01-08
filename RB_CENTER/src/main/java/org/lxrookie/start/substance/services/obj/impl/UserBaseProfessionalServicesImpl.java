package org.lxrookie.start.substance.services.obj.impl;

import org.lxrookie.start.substance.base.services.BaseServices;
import org.lxrookie.start.substance.dao.UserBaseProfessionalDao;
import org.lxrookie.start.substance.entity.UserBaseProfessionalEntity;
import org.lxrookie.start.substance.services.obj.UserBaseProfessionalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userBaseProfessionalServices")
public class UserBaseProfessionalServicesImpl extends BaseServices<UserBaseProfessionalEntity> implements UserBaseProfessionalServices {


    @Autowired
    private UserBaseProfessionalDao userBaseProfessionalDao;

    @Override
    public List<UserBaseProfessionalEntity> selectAllUserBaseProfessional() {
        return ((UserBaseProfessionalDao) userBaseProfessionalDao).selectAllUserBaseProfessional();
    }

    @Override
    public int insertUserBaseProfessional(UserBaseProfessionalEntity userBaseMessageProfessionalEntity) {
        return ((UserBaseProfessionalDao) userBaseProfessionalDao).insert(userBaseMessageProfessionalEntity);
    }

    @Override
    public UserBaseProfessionalEntity selectUserBaseProfessionalEntityByPrimaryKey(String uid) {
        return ((UserBaseProfessionalDao) userBaseProfessionalDao).selectByPrimaryKey(uid);
    }

}
