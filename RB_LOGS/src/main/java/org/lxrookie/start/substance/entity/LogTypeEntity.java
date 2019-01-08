package org.lxrookie.start.substance.entity;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 *------------------------------.
 *@ClassName : LogTypeEntity
 *@author : 沐惜
 *@createTime : 2018/11/26 18:52
 *@描述 : 日志类型
 *@Version : 1.0
 *------------------------------
 */
@Table(name = "LOG_TYPE")
public class LogTypeEntity {

    /**
     * 日志类型ID
     */
    @Id
    @Column(name = "LOG_TYPE_ID")
    private String logTypeId;
    /**
     * 日志类型名称
     */
    @Column(name = "LOG_TYPE_DIRECTORY")
    private String logTypeDirectory;
    /**
     * 日志目录使用状态 0 开启    1  关闭
     */
    @Column(name = "LOG_TYPE_STATE")
    private Integer logTypeState;
    /**
     * 日志类型createTime按
     */
    @Column(name = "LOG_TYPE_CREATE_TIME")
    private Date logTypeCreateTime;

    /**
     * 日志类型描述
     */
    @Column(name = "LOG_TYPE_DIRECTORY_DESCRIBE")
    private String logTypeDirectoryDescribe;

    /**
     * 日志类型状态码
     */
    @Column(name = "LOG_TYPE_OPERATION_CODE")
    private String logTypeOperationCode;


    public void setLogTypeOperationCode(String logTypeOperationCode) {
        this.logTypeOperationCode = logTypeOperationCode;
    }

    public String getLogTypeOperationCode() {
        return logTypeOperationCode;
    }

    public void setLogTypeDirectoryDescribe(String logTypeDirectoryDescribe) {
        this.logTypeDirectoryDescribe = logTypeDirectoryDescribe;
    }

    public String getLogTypeDirectoryDescribe() {
        return logTypeDirectoryDescribe;
    }

    public void setLogTypeId(String logTypeId) {
        this.logTypeId = logTypeId;
    }

    public void setLogTypeDirectory(String logTypeDirectory) {
        this.logTypeDirectory = logTypeDirectory;
    }

    public void setLogTypeState(Integer logTypeState) {
        this.logTypeState = logTypeState;
    }

    public Integer getLogTypeState() {
        return logTypeState;
    }

    public void setLogTypeCreateTime(Date logTypeCreateTime) {
        this.logTypeCreateTime = logTypeCreateTime;
    }

    public String getLogTypeId() {
        return logTypeId;
    }

    public String getLogTypeDirectory() {
        return logTypeDirectory;
    }



    public Date getLogTypeCreateTime() {
        return logTypeCreateTime;
    }
}
