package org.lxrookie.start.substance.services.obj;

import org.lxrookie.start.substance.entity.UserBaseMessageEntity;

/**
 *------------------------------.
 * @name : UserBaseMessageServices
 * @author : 沐惜
 * @createTime : 2018/12/3 11:15
 * @description : UserBaseMessage对象
 * @Version : 1.0
 *------------------------------
 */
public interface UserBaseMessageServices {
            /**
             *------------------------------.
             * @name : UserBaseMessageServices
             * @author : 沐惜
             * @param : userId 用户id
             * @Return : UserBaseMessage
             * @createTime : 2018/12/3 11:16
             * @description : 通过id查询用户对象
             * @Version : 1.0
             *------------------------------
             */
            public UserBaseMessageEntity selectUserBaseMessageById(String userId);







}
