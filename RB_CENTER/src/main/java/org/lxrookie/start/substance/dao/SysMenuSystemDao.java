package org.lxrookie.start.substance.dao;

import org.lxrookie.start.substance.base.dao.BaseDao;
import org.lxrookie.start.substance.entity.SysMenuSystemEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SysMenuSystemDao extends BaseDao<SysMenuSystemEntity> {
    /**
     *------------------------------.
     * @name : SysMenuSystemDao
     * @author : 沐惜
     * @createTime : 2019/1/7 10:54
     * @description : 按模块查询  升序排序
     * @Version : 1.0
     *------------------------------
     */
    public List<SysMenuSystemEntity> selectAllSysMentSystenSort(SysMenuSystemEntity sysMenuSystemEntity);
}
