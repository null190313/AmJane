package org.lxrookie.start.substance.services.obj;


import org.lxrookie.start.substance.entity.SysMenuSystemEntity;

import java.util.List;

/**
 *------------------------------.
 * @name : SysMenuSystemServices
 * @author : 沐惜
 * @createTime : 2019/1/7 10:45
 * @description : 系统菜单配置接口
 * @Version : 1.0
 *------------------------------
 */
public interface SysMenuSystemServices {


            /**
             *------------------------------.
             * @name : SysMenuSystemServices
             * @author : 沐惜
             * @Param :
             * @Return :
             * @createTime : 2019/1/7 10:52
             * @description : 查询单模块所有对应菜单sortCode升序排序
             * @Version : 1.0
             *------------------------------
             */
            public List<SysMenuSystemEntity> selectAllSysMenuSystemSort(String marking);

}
