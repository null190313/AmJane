package org.lxrookie.start.substance.services.obj.impl;

import org.lxrookie.start.substance.base.services.BaseServices;
import org.lxrookie.start.substance.dao.SysMenuSystemDao;
import org.lxrookie.start.substance.entity.SysMenuSystemEntity;
import org.lxrookie.start.substance.services.obj.SysMenuSystemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 *------------------------------.
 * @name : SysMenuSystemServicesImpl
 * @author : 沐惜
 * @createTime : 2019/1/7 10:46
 * @description : 系统菜单实现类
 * @Version : 1.0
 *------------------------------
 */
@Service("sysMenuSystemServices")
public class SysMenuSystemServicesImpl extends BaseServices<SysMenuSystemEntity> implements SysMenuSystemServices {

    @Autowired
    private SysMenuSystemDao sysMenuSystemDao;

    @Override
    public List<SysMenuSystemEntity> selectAllSysMenuSystemSort(String marking) {
        SysMenuSystemEntity sysMenuSystemEntity = new SysMenuSystemEntity();
        sysMenuSystemEntity.setSysMenuMarking(marking);
        return ((SysMenuSystemDao)sysMenuSystemDao).selectAllSysMentSystenSort(sysMenuSystemEntity);
    }
}
