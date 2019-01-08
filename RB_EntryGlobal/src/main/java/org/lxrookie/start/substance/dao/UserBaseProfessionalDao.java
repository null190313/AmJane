package org.lxrookie.start.substance.dao;

import org.apache.ibatis.annotations.Param;
import org.lxrookie.start.substance.base.dao.BaseDao;
import org.lxrookie.start.substance.entity.UserBaseProfessionalEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *------------------------------.
 * @name : UserBaseMessageProfessionalDao
 * @author : 沐惜
 * @createTime : 2018/12/10 13:31
 * @description : 职业信息
 * @Version : 1.0
 *------------------------------
 */
@Component
public interface UserBaseProfessionalDao extends BaseDao<UserBaseProfessionalEntity> {


    /**
     *------------------------------.
     * @name : UserBaseMessageProfessionalDao
     * @author : 沐惜
     * @createTime : 2018/12/10 13:32
     * @description : 查询所有开启状态职业信息 状态 0
     * @Version : 1.0
     *------------------------------
     */
    public List<UserBaseProfessionalEntity> selectAllUserBaseProfessional();




}
