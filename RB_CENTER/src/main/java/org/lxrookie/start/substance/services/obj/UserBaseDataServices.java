package org.lxrookie.start.substance.services.obj;

import org.lxrookie.start.substance.entity.UserBaseDataEntity;

/**
 *------------------------------.
 * @name : UserBaseDataServices
 * @author : 沐惜
 * @createTime : 2019/1/7 20:38
 * @description : 用户基础数据量
 * @Version : 1.0
 *------------------------------
 */
public interface UserBaseDataServices {

        /**
         *------------------------------.
         * @name : UserBaseDataServices
         * @author : 沐惜
         * @createTime : 2019/1/7 21:55
         * @description : 根据UserId查询
         * @Version : 1.0
         *------------------------------
         */
        public UserBaseDataEntity selectUserBaseDataEntityByUserId(String userId);
}
