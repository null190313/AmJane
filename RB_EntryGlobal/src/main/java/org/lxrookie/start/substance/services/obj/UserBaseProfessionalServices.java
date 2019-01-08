package org.lxrookie.start.substance.services.obj;

import org.lxrookie.start.substance.entity.UserBaseProfessionalEntity;

import java.util.List;

/**
 *------------------------------.
 * @name : UserBaseMessageProfessionalServices
 * @author : 沐惜
 * @createTime : 2018/12/10 13:28
 * @description : 职业信息
 * @Version : 1.0
 *------------------------------
 */
public interface UserBaseProfessionalServices {


    /**
     *------------------------------.
     * @name : UserBaseMessageProfessionalServices
     * @author : 沐惜
     * @createTime : 2018/12/10 13:29
     * @description : 查询所有开启状态的职业信息
     * @Version : 1.0
     *------------------------------
     */
    public List<UserBaseProfessionalEntity> selectAllUserBaseProfessional();

    /**
     *------------------------------.
     * @name : UserBaseMessageProfessionalServices
     * @author : 沐惜
     * @createTime : 2018/12/10 14:04
     * @description : 基础插入语句
     * @Version : 1.0
     *------------------------------
     */
    public int insertUserBaseProfessional(UserBaseProfessionalEntity userBaseProfessionalEntity);





}
