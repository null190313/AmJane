package org.lxrookie.start.substance.services.obj.impl;


import org.lxrookie.start.substance.base.services.BaseServices;
import org.lxrookie.start.substance.dao.SysConfigDao;
import org.lxrookie.start.substance.entity.SysConfigEntity;
import org.lxrookie.start.substance.services.obj.SysConfigServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ------------------------------.
 *
 * @author : 沐惜
 * @ClassName : SysConfigServicesImpl
 * @createTime : 2018/11/26 20:04
 * @描述 : TODO
 * @Version : 1.0
 * ------------------------------
 */
@Service("sysConfigServices")
public class SysConfigServicesImpl extends BaseServices<SysConfigEntity> implements SysConfigServices {

    @Autowired
    private SysConfigDao sysConfigDao;

    @Override
    public String selectSysConfigByKey(String key) {
        return ((SysConfigDao)getMapper()).selectSysConfigByKey(key);
    }
    @Override
    public void insertSysConfigObj(SysConfigEntity sysConfigEntity) {
        ((SysConfigDao)getMapper()).insertSysConfigObj(sysConfigEntity);
    }

    @Override
    public void closeSysConfig(SysConfigEntity sysConfigEntity) {
        ((SysConfigDao)getMapper()).closeSysConfig(sysConfigEntity);
    }
}
