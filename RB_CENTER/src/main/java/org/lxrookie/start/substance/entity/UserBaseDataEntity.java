package org.lxrookie.start.substance.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.sql.Date;

/**
 *------------------------------.
 * @name : UserBaseDataEntity
 * @author : 沐惜
 * @createTime : 2019/1/7 20:31
 * @description : 用户基础信息数据量
 * @Version : 1.0
 *------------------------------
 */
@Table(name = "USER_BASE_DATA")
public class UserBaseDataEntity {

    @Column(name = "USER_DATA_ID")
    private String userDataId;

    @Column(name = "USER_MESSAGE_ID")
    private String userMessageId;

    @Column(name = "USER_MESSAGE_FOCUS")
    private Integer userMessageFocus;

    @Column(name = "USER_MESSAGE_FANS")
    private Integer userMessageFans;

    @Column(name = "USER_MESSAGE_BLOG")
    private Integer userMessageBlog;

    @Column(name = "USER_MESSAGE_SHARED")
    private Integer userMessageShared;

    @Column(name = "USER_MESSAGE_STORAGE")
    private Double userMessageStorage;

    @Column(name = "USER_MESSAGE_ALTERTIME")
    private Date userMessageAlterTime;

    public void setUserDataId(String userDataId) {
        this.userDataId = userDataId;
    }

    public void setUserMessageId(String userMessageId) {
        this.userMessageId = userMessageId;
    }

    public void setUserMessageFocus(Integer userMessageFocus) {
        this.userMessageFocus = userMessageFocus;
    }

    public void setUserMessageFans(Integer userMessageFans) {
        this.userMessageFans = userMessageFans;
    }

    public void setUserMessageBlog(Integer userMessageBlog) {
        this.userMessageBlog = userMessageBlog;
    }

    public void setUserMessageShared(Integer userMessageShared) {
        this.userMessageShared = userMessageShared;
    }

    public void setUserMessageStorage(Double userMessageStorage) {
        this.userMessageStorage = userMessageStorage;
    }

    public void setUserMessageAlterTime(Date userMessageAlterTime) {
        this.userMessageAlterTime = userMessageAlterTime;
    }

    public String getUserDataId() {
        return userDataId;
    }

    public String getUserMessageId() {
        return userMessageId;
    }

    public Integer getUserMessageFocus() {
        return userMessageFocus;
    }

    public Integer getUserMessageFans() {
        return userMessageFans;
    }

    public Integer getUserMessageBlog() {
        return userMessageBlog;
    }

    public Integer getUserMessageShared() {
        return userMessageShared;
    }

    public Double getUserMessageStorage() {
        return userMessageStorage;
    }

    public Date getUserMessageAlterTime() {
        return userMessageAlterTime;
    }
}
