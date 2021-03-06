package org.lxrookie.start.substance.dao;


import org.apache.ibatis.annotations.Param;
import org.lxrookie.start.substance.base.dao.BaseDao;
import org.lxrookie.start.substance.entity.SysConfigEntity;
import org.springframework.stereotype.Component;

/**
 *------------------------------.
 *@ClassName : SysConfigDao
 *@author : 沐惜
 *@createTime : 2018/11/26 20:05
 *@描述 : TODO
 *@Version : 1.0
 *------------------------------
 */
@Component
public interface SysConfigDao extends BaseDao<SysConfigEntity> {
    /**
     *------------------------------.
     * @name : SysConfigDao
     * @author : 沐惜
     * @Param : key : SysConfig key
     * @Return : String
     * @createTime : 2018/12/2 18:02
     * @description : TODO
     * @Version : 1.0
     *------------------------------
     */
    public String selectSysConfigByKey(@Param("key") String key);

    /**
     *------------------------------.
     * @name : SysConfigDao
     * @author : 沐惜
     * @Param : sysConfigEntity
     * @Return : String
     * @createTime : 2018/12/2 18:03
     * @description : 基本插入对象
     * @Version : 1.0
     *------------------------------
     */
    public String insertSysConfigObj(@Param("sysConfigEntity")SysConfigEntity sysConfigEntity);


    public void closeSysConfig(@Param("sysConfigEntity")SysConfigEntity sysConfigEntity);
}
