package org.lxrookie.start.substance.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.sql.Date;

/**
 *------------------------------.
 * @name : SysPhoneMessageEntity
 * @author : 沐惜
 * @createTime : 2019/1/4 17:31
 * @description : 信息发送记录
 * @Version : 1.0
 *------------------------------
 */
@Table(name = "SYS_PHONE_MESSAGE")
public class SysPhoneMessageEntity {

    /**
     * UUID
     * */
    @Column(name = "SYS_PHONE_ID")
    private String sysPhoneId;

    /**
     * 发送的手机号码
     * */
    @Column(name = "SYS_PHONE_NUM")
    private String sysPhoneNum;

    /**
     * 短信内容
     * */
    @Column(name = "SYS_PHONE_CONTENT")
    private String sysPhoneContent;

    /**
     * 发送的用户ID
     * 当SYS_PHONE_CATEGORY_STATE 为 0 时
     * SYS_PHONE_USER_ID 为空
     * */
    @Column(name = "SYS_PHONE_USER_ID")
    private String sysPhoneUserId;

    /**
     * 发送类别
     * 0 : 注册
     * 1 : 其他
     * */
    @Column(name = "SYS_PHONE_CATEGORY_STATE")
    private Integer sysPhoneCategoryState;

    /**
     * 发送时间
     * */
    @Column(name = "SYS_PHONE_CREATE_TIME")
    private Date sysPhoneCreateTime;


    public void setSysPhoneId(String sysPhoneId) {
        this.sysPhoneId = sysPhoneId;
    }

    public void setSysPhoneNum(String sysPhoneNum) {
        this.sysPhoneNum = sysPhoneNum;
    }

    public void setSysPhoneContent(String sysPhoneContent) {
        this.sysPhoneContent = sysPhoneContent;
    }

    public void setSysPhoneUserId(String sysPhoneUserId) {
        this.sysPhoneUserId = sysPhoneUserId;
    }

    public void setSysPhoneCategoryState(Integer sysPhoneCategoryState) {
        this.sysPhoneCategoryState = sysPhoneCategoryState;
    }

    public void setSysPhoneTime(Date sysPhoneTime) {
        this.sysPhoneCreateTime = sysPhoneTime;
    }

    public String getSysPhoneId() {
        return sysPhoneId;
    }

    public String getSysPhoneNum() {
        return sysPhoneNum;
    }

    public String getSysPhoneContent() {
        return sysPhoneContent;
    }

    public String getSysPhoneUserId() {
        return sysPhoneUserId;
    }

    public Integer getSysPhoneCategoryState() {
        return sysPhoneCategoryState;
    }

    public Date getSysPhoneTime() {
        return sysPhoneCreateTime;
    }

    public void setSysPhoneCreateTime(Date sysPhoneCreateTime) {
        this.sysPhoneCreateTime = sysPhoneCreateTime;
    }

    public Date getSysPhoneCreateTime() {
        return sysPhoneCreateTime;
    }
}
