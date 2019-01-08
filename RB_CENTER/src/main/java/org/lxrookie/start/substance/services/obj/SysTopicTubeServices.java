package org.lxrookie.start.substance.services.obj;

import org.lxrookie.start.substance.entity.SysTopicTubeEntity;

/**
 *------------------------------.
 * @name : SysTopicTubeServices
 * @author : 沐惜
 * @createTime : 2018/11/30 19:07
 * @description : TODO
 * @Version : 1.0
 *------------------------------
 */
public interface SysTopicTubeServices {

    /**
     *------------------------------.
     * @name : SysTopicTubeServices
     * @author : 沐惜
     * @Param : key
     * @Return : String
     * @createTime : 2018/11/30 19:08
     * @description : TODO
     * @Version : 1.0
     *------------------------------
     */
    public SysTopicTubeEntity selectSysTopicTubeEntity(String key);

    /**
     *------------------------------.
     * @name : SysTopicTubeServices
     * @author : 沐惜
     * @Param : sysTopicTubeEntity对象
     * @Return :  void
     * @createTime : 2018/12/2 17:06
     * @description : TODO
     * @Version : 1.0
     *------------------------------
     */
    public void insertSysTopicTubeEntity(SysTopicTubeEntity sysTopicTubeEntity);


}
