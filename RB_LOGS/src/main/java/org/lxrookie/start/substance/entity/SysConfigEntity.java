package org.lxrookie.start.substance.entity;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 *------------------------------.
 *@ClassName : SysConfigEntity
 *@author : 沐惜
 *@createTime : 2018/11/26 19:44
 *@描述 : 系统配置
 *@Version : 1.0
 *------------------------------
 */
@Table(name = "SYS_CONFIG")
public class SysConfigEntity {

    /**
     * 系统配置ID
     */
    @Id
    @Column(name = "SYS_CONFIG_ID")
    private String sysConfigId;

    /**
     * 系统配置key
     */
    @Column(name = "SYS_CONFIG_KEY")
    private String sysConfigKey;

    /**
     * 系统配置Value
     */
    @Column(name = "SYS_CONFIG_VALUE")
    private String sysConfigValue;

    /**
     * 系统配置使用状态 0:开启    1:关闭
     */
    @Column(name = "SYS_CONFIG_STATE")
    private String sysConfigState;

    /**
     * 系统配置添加时间
     */
    @Column(name = "SYS_CONFIG_CREATE_TIME")
    private Date sysConfigCreateTime;

    /**
     * 信息描述
     */
    @Column(name = "SYS_CONFIG_DESCRIPTION")
    private Date sysConfigDescription;


    public void setSysConfigDescription(Date sysConfigDescription) {
        this.sysConfigDescription = sysConfigDescription;
    }

    public Date getSysConfigDescription() {
        return sysConfigDescription;
    }

    public void setSysConfigId(String sysConfigId) {
        this.sysConfigId = sysConfigId;
    }

    public void setSysConfigKey(String sysConfigKey) {
        this.sysConfigKey = sysConfigKey;
    }

    public void setSysConfigValue(String sysConfigValue) {
        this.sysConfigValue = sysConfigValue;
    }

    public void setSysConfigState(String sysConfigState) {
        this.sysConfigState = sysConfigState;
    }

    public void setSysConfigCreateTime(Date sysConfigCreateTime) {
        this.sysConfigCreateTime = sysConfigCreateTime;
    }

    public Date getSysConfigCreateTime() {
        return sysConfigCreateTime;
    }

    public String getSysConfigId() {
        return sysConfigId;
    }

    public String getSysConfigKey() {
        return sysConfigKey;
    }

    public String getSysConfigValue() {
        return sysConfigValue;
    }

    public String getSysConfigState() {
        return sysConfigState;
    }

}
