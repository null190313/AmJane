package org.lxrookie.start.substance.util.obj;


import com.ccb.openframework.util.FrameworkContext;
import org.lxrookie.start.substance.services.obj.SysConfigServices;

/**
 *------------------------------.
 *@ClassName : SysConfigUtils
 *@author : 沐惜
 *@createTime : 2018/11/26 20:01
 *@描述 : SYS_CONFIG工具类
 *@Version : 1.0
 *------------------------------
 */
public class SysConfigUtils {

    /**
    *------------------------------.
    * @MethodName : getSysConfigByKey
    * @author : 沐惜
    * @param :key
    * @return : return value
    * @createTime : 2018/11/26 20:04
    * @description : TODO
    * @Version : 1.0
    *------------------------------
    */
    public static String getSysConfigByKey(String key){
        SysConfigServices sysConfigServices = (SysConfigServices) FrameworkContext.getApplicationContext().getBean("sysConfigServices");
        return sysConfigServices.selectSysConfigByKey(key) == null ? "" : sysConfigServices.selectSysConfigByKey(key) ;
    }


}
