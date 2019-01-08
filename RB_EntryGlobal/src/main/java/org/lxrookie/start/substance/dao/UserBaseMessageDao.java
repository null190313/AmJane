package org.lxrookie.start.substance.dao;

import org.apache.ibatis.annotations.Param;
import org.lxrookie.start.substance.base.dao.BaseDao;
import org.lxrookie.start.substance.entity.UserBaseMessageEntity;

/**
 *------------------------------.
 * @name : UserBaseMessageDao
 * @author : 沐惜
 * @createTime : 2018/12/3 11:20
 * @description : UserBaseMessage数据交换层接口
 * @Version : 1.0
 *------------------------------
 */
public interface UserBaseMessageDao extends BaseDao<UserBaseMessageEntity> {


    /**
     *------------------------------.
     * @name : UserBaseProfessionalDao
     * @author : 沐惜
     * @createTime : 2018/12/18 18:43
     * @description : 通过手机号查询用户
     * @Version : 1.0
     *------------------------------
     */
    public UserBaseMessageEntity selectUserBaseMessageByPhone(@Param("phone") String phone);


    /**
     *------------------------------.
     * @name : UserBaseMessageDao
     * @author : 沐惜
     * @createTime : 2018/12/19 18:57
     * @description : 查询昵称是否重复
     * @Version : 1.0
     *------------------------------
     */
    public UserBaseMessageEntity selectUserBaseByNickName(@Param("nickName") String nickName);

    /**
     *------------------------------.
     * @name : UserBaseMessageDao
     * @author : 沐惜
     * @createTime : 2018/12/20 15:33
     * @description : 手动添加注册用户
     * @Version : 1.0
     *------------------------------
     */
    public void insertUserBaseMessageEntity(UserBaseMessageEntity userBaseMessageEntity);

    /**
     *------------------------------.
     * @name : UserBaseMessageDao
     * @author : 沐惜
     * @createTime : 2018/12/24 12:17
     * @description : 查询账号是否存在
     * @Version : 1.0
     *------------------------------
     */
    public UserBaseMessageEntity selectUserBaseByAccount(@Param("userAccount") String userAccount);


    /**
     *------------------------------.
     * @name : UserBaseMessageDao
     * @author : 沐惜
     * @createTime : 2019/1/2 16:21
     * @description : 验证登录用户信息是否正确
     * @Version : 1.0
     *------------------------------
     */
    public UserBaseMessageEntity selectUserBaseByUserAccountOrPhone(UserBaseMessageEntity userBaseMessageEntity);



}
