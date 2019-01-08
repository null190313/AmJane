package org.lxrookie.start.substance.services.obj;

import org.lxrookie.start.substance.entity.SysPhoneMessageEntity;
import org.springframework.stereotype.Service;

/**
 *------------------------------.
 * @name : SysPhoneMessageServices
 * @author : 沐惜
 * @createTime : 2019/1/4 17:36
 * @description : 短信发送接口
 * @Version : 1.0
 *------------------------------
 */
public interface SysPhoneMessageServices {

    /**
     *------------------------------.
     * @name : SysPhoneMessageServices
     * @author : 沐惜
     * @createTime : 2019/1/4 17:41
     * @description : 基础插入数据
     * @Version : 1.0
     *------------------------------
     */
    public void insertSysPhoneMessage(SysPhoneMessageEntity sysPhoneMessageEntity);


}
