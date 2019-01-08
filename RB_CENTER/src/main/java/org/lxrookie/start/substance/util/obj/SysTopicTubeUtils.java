package org.lxrookie.start.substance.util.obj;

import org.lxrookie.start.substance.services.obj.SysTopicTubeServices;
import org.lxrookie.start.substance.util.SpringUtils;

/**
 *------------------------------.
 * @name : SysTopicTubeUtils
 * @author : 沐惜
 * @createTime : 2018/12/1 9:40
 * @description : TODO
 * @Version : 1.0
 *------------------------------
 */
public class SysTopicTubeUtils {

        public static String getTopicBySysTopicTubeKey(String key){
            SysTopicTubeServices sysTopicTubeServices = (SysTopicTubeServices) SpringUtils.getBean("sysTopicTubeServices");
            return sysTopicTubeServices.selectSysTopicTubeEntity(key).getSysTopicTubeValue() == null ? "" : sysTopicTubeServices.selectSysTopicTubeEntity(key).getSysTopicTubeValue();
        }
}
