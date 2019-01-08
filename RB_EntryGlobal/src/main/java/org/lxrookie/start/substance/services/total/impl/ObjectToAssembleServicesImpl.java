package org.lxrookie.start.substance.services.total.impl;

import org.lxrookie.start.substance.constant.SysConfigConstant;
import org.lxrookie.start.substance.entity.SysPhoneMessageEntity;
import org.lxrookie.start.substance.entity.UserBaseMessageEntity;
import org.lxrookie.start.substance.services.total.ObjectToAssembleServices;
import org.lxrookie.start.substance.services.total.VerificationCodeServices;
import org.lxrookie.start.substance.util.DateUtils;
import org.lxrookie.start.substance.util.MD5Utils;
import org.lxrookie.start.substance.util.TotalUtils;
import org.lxrookie.start.substance.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

@Service("objectToAssembleServices")
public class ObjectToAssembleServicesImpl implements ObjectToAssembleServices {
    @Autowired
    private VerificationCodeServices verificationCodeServices;

    @Override
    public UserBaseMessageEntity assembleUserBaseMessage(HttpServletRequest httpServletRequest, UserBaseMessageEntity userBaseMessageEntity) {
        boolean isMoblie = TotalUtils.JudgeIsMoblie(httpServletRequest);


        /**
         * ID
         * */
        userBaseMessageEntity.setUserId(UUIDUtils.uuid());
        /**
         * 账号
         * */
        userBaseMessageEntity.setUserAccount(verificationCodeServices.generateAccount());
        /**
         * 注册类型
         * */
        if (!isMoblie) {
            userBaseMessageEntity.setUserType(1);
        } else {
            userBaseMessageEntity.setUserType(5);
        }
        /**
         * 密码加密MD5
         * */
        userBaseMessageEntity.setUserPasword(MD5Utils.getMD5Code(userBaseMessageEntity.getUserPasword()));
        userBaseMessageEntity.setUserHeadPicUrl(SysConfigConstant.USER_REGISTER_DEFAULT_PIC_URL);
        userBaseMessageEntity.setUserHeadPicUrl("https://2019-new-rookie-blog.oss-cn-beijing.aliyuncs.com/center/persion/default-pic.png");
        return userBaseMessageEntity;
    }

    @Override
    public SysPhoneMessageEntity assembleSysPhoneMessage(SysPhoneMessageEntity sysPhoneMessageEntity, String sysPhoneNum, String sysPhoneContent, String sysPhoneUserId, Integer sysPhoneCategoryState) {
        sysPhoneMessageEntity.setSysPhoneId(UUIDUtils.uuid());
        sysPhoneMessageEntity.setSysPhoneNum(sysPhoneNum);
        sysPhoneMessageEntity.setSysPhoneContent(sysPhoneContent);
        if (0 == sysPhoneCategoryState) {
            sysPhoneMessageEntity.setSysPhoneUserId("");
        } else {
            sysPhoneMessageEntity.setSysPhoneUserId(sysPhoneUserId);
        }
        sysPhoneMessageEntity.setSysPhoneCategoryState(sysPhoneCategoryState);
        sysPhoneMessageEntity.setSysPhoneTime(DateUtils.tranDate());
        return sysPhoneMessageEntity;
    }
}
