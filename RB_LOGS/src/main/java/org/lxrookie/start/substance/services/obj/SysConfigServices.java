package org.lxrookie.start.substance.services.obj;


import org.lxrookie.start.substance.entity.SysConfigEntity;

/**
 *------------------------------.
 *@ClassName : SysConfigServices
 *@author : 沐惜
 *@createTime : 2018/11/26 19:53
 *@描述 : SysConfig系统配置
 *@Version : 1.0
 *------------------------------
 */
public interface SysConfigServices {

    /**
    *------------------------------.
    * @MethodName : selectSysConfigByKey
    * @author : 沐惜
    * @param :   key
    *  *@return :  String
    * @createTime : 2018/11/26 20:00
    * @description : 通过KEY查找SYS_CONFIG  VALUE值
    * @Version : 1.0
    *------------------------------
    */
    public String selectSysConfigByKey(String key);

    /**
    *------------------------------.
    * @MethodName : SysConfigServices
    * @author : 沐惜
    * @param : SysConfigEntity
    *  *@return :  Stirng 返回插入主键
    * @createTime : 2018/11/26 20:11
    * @description : TODO
    * @Version : 1.0
    *------------------------------
    */
    public void insertSysConfigObj(SysConfigEntity sysConfigEntity);


    public void closeSysConfig(SysConfigEntity sysConfigEntity);
}
