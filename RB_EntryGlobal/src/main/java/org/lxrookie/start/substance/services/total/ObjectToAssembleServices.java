package org.lxrookie.start.substance.services.total;

import org.lxrookie.start.substance.entity.SysPhoneMessageEntity;
import org.lxrookie.start.substance.entity.UserBaseMessageEntity;

import javax.servlet.http.HttpServletRequest;

/**
 *------------------------------.
 * @name : objectToAssembleServices
 * @author : 沐惜
 * @createTime : 2018/12/24 12:24
 * @description : 对象组装
 * @Version : 1.0
 *------------------------------
 */
public interface ObjectToAssembleServices {

    /**
     *------------------------------.
     * @name : objectToAssembleServices
     * @author : 沐惜
     * @createTime : 2018/12/24 12:25
     * @description : 注册账户时组装用户对象
     * @Version : 1.0
     *------------------------------
     */
    public UserBaseMessageEntity assembleUserBaseMessage(HttpServletRequest httpServletRequest,UserBaseMessageEntity userBaseMessageEntity);

    /**
     *------------------------------.
     * @name : ObjectToAssembleServices
     * @author : 沐惜
     * @createTime : 2019/1/4 17:46
     * @description : 短信发送实体封装
     * @Version : 1.0
     *------------------------------
     */
    public SysPhoneMessageEntity assembleSysPhoneMessage(SysPhoneMessageEntity sysPhoneMessageEntity,String sysPhoneNum,String sysPhoneContent,String sysPhoneUserId,Integer sysPhoneCategoryState );






}
