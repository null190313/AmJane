package org.lxrookie.start.substance.services.obj;

import org.lxrookie.start.substance.dao.UserBaseMessageDao;
import org.lxrookie.start.substance.entity.UserBaseMessageEntity;
import org.lxrookie.start.substance.entity.UserBaseProfessionalEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

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


        /**
         *------------------------------.
         * @name : UserBaseMessageServices
         * @author : 沐惜
         * @Param : userBaseMessageEntity  注册填写信息进行监测
         * @Return : Map 注册信息检测结果
         * @createTime : 2018/12/9 16:32
         * @description : TODO
         * @Version : 1.0
         *------------------------------
         */
        public Map<String,String> registeredCheckInformation(UserBaseMessageEntity userBaseMessageEntity);


        /**
         *------------------------------.
         * @name : UserBaseMessageServices
         * @author : 沐惜
         * @createTime : 2018/12/19 10:59
         * @description : 发送验证码前的基础信息检查
         * @Version : 1.0
         *------------------------------
         */
        public Map<String,String> achieveSMSCheckInfo(String nickName,String firstPassword,String secondPassword,String userPhone);



        /**
         *------------------------------.
         * @name : UserBaseProfessionalServices
         * @author : 沐惜
         * @Param : phone注册填写手机号
         * @Return : UserBaseMessageEntity 返回查询到的对象
         * @createTime : 2018/12/18 18:42
         * @description : 通过手机查询用户
         * @Version : 1.0
         *------------------------------
         */
        public UserBaseMessageEntity selectUserBaseMessageEntityByPhone(String phone);

        /**
         *------------------------------.
         * @name : UserBaseMessageServices
         * @author : 沐惜
         * @createTime : 2018/12/19 18:53
         * @description : 校验当前数据是否重复
         * @Version : 1.0
         *------------------------------
         */
        public Map<String,String> checkInfoIsRepeat(String nickName,String firstPassword,String secondPassword,String userPhone);


        /**
         *------------------------------.
         * @name : UserBaseMessageServices
         * @author : 沐惜
         * @createTime : 2019/1/2 16:19
         * @description : 验证登录信息是否正确
         * @Version : 1.0
         *------------------------------
         */
        public Map<String,String> checkLoginInfo(UserBaseMessageEntity userBaseMessageEntity, HttpServletRequest request, HttpServletResponse response);


        /**
         *------------------------------.
         * @name : UserBaseMessageServices
         * @author : 沐惜
         * @createTime : 2019/1/2 16:31
         * @description : 登录成功信息数据写入
         *                1.cookieId     cookie存入
         *                2.cookieToken  session+cookie存入
         *                3.SysConfigConstant.USER_BASE_REDIS_COOKIEID + cookieId               cookie + redis
         *                过期时间 3600s 1小时
         * @Version : 1.0
         *------------------------------
         */
        public void writingLoginInformation(UserBaseMessageEntity userBaseMessageEntity,HttpServletRequest request, HttpServletResponse response);
}
