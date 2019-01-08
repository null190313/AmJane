package org.lxrookie.start.substance.services.obj.impl;


import org.lxrookie.start.substance.base.services.BaseServices;
import org.lxrookie.start.substance.dao.SysTopicTubeDao;
import org.lxrookie.start.substance.entity.SysTopicTubeEntity;
import org.lxrookie.start.substance.services.obj.SysTopicTubeServices;
import org.springframework.stereotype.Service;

/**
 *------------------------------.
 * @name : SysTopicTubeServicesImpl
 * @author : 沐惜
 * @createTime : 2018/12/2 17:18
 * @description : TODO
 * @Version : 1.0
 *------------------------------
 */
@Service("sysTopicTubeServices")
public class SysTopicTubeServicesImpl extends BaseServices<SysTopicTubeEntity> implements SysTopicTubeServices {


    @Override
    public SysTopicTubeEntity selectSysTopicTubeEntity(String key) {
        return  ((SysTopicTubeDao)getMapper()).selectSysTopicTubeEntity(key);
    }

    @Override
    public void insertSysTopicTubeEntity(SysTopicTubeEntity sysTopicTubeEntity) {
         ((SysTopicTubeDao)getMapper()).insert(sysTopicTubeEntity);
    }


}
