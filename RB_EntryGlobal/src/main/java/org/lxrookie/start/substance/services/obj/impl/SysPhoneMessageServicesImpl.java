package org.lxrookie.start.substance.services.obj.impl;

import org.lxrookie.start.substance.base.services.BaseServices;
import org.lxrookie.start.substance.dao.SysPhoneMessageDao;
import org.lxrookie.start.substance.entity.SysPhoneMessageEntity;
import org.lxrookie.start.substance.services.obj.SysPhoneMessageServices;
import org.lxrookie.start.substance.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *------------------------------.
 * @name : SysPhoneMessageServicesImpl
 * @author : 沐惜
 * @createTime : 2019/1/4 17:37
 * @description : 短信发送实现类
 * @Version : 1.0
 *------------------------------
 */
@Service("sysPhoneMessageServices")
public class SysPhoneMessageServicesImpl extends BaseServices<SysPhoneMessageEntity> implements SysPhoneMessageServices {

    @Autowired
    private SysPhoneMessageDao sysPhoneMessageDao;

    @Override
    public void insertSysPhoneMessage(SysPhoneMessageEntity sysPhoneMessageEntity) {
        sysPhoneMessageEntity.setSysPhoneCreateTime(DateUtils.tranDate());
        ((SysPhoneMessageDao)getMapper()).insert(sysPhoneMessageEntity);
    }
}
