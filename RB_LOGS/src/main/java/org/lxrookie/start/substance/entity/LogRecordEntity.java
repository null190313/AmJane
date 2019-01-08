package org.lxrookie.start.substance.entity;

import java.util.Date;
/**
 *------------------------------.
 *@ClassName : LogRecordEntity
 *@author : 沐惜
 *@createTime : 2018/11/26 19:02
 *@描述 : 日志内容
 *@Version : 1.0
 *------------------------------
 */
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "LOG_RECORD")
public class LogRecordEntity {

    /**
     * 日志目录类 关联LOT_TYPE_ID
     */
    @Id
    @Column(name = "LOG_RECORD_ID")
    private String logRecordId;
    /**
     * 日志目录类 关联LOT_TYPE_ID
     */
    @Column(name = "LOG_RECORD_TYPE_ID")
    private String logRecordTypeId;
    /**
     * 日志记录实体内容
     */
    @Column(name = "LOG_RECORD_COMMENT")
    private String logRecordComment;
    /**
     * 日志目录级别 DEBUG INFO WARN ERROR FATAL
     */
    @Column(name = "LOG_RECORD_LEVEL")
    private String logRecordLevel;
    /**
     * 日志记录时间
     */
    @Column(name = "LOG_RECORD_CREATE_TIME")
    private Date logRecordCreateTime;
    /**
     * 日志记录状态 0:记录  1:忽略
     */
    @Column(name = "LOG_RECORD_STATE")
    private Integer logRecordState;
    /**
     * 日志记录使用客户端 0:PC 1:APP
     */
    @Column(name = "LOG_RECORD_CLIENT")
    private Integer logRecordClient;
    /**
     * 日志输出文件路径ID 关联LOG_RECORD_ID
     */
    @Column(name = "LOG_RECORD_OUTPUT_FILEPATH_ID")
    private String logRecordOutPutFilepathId;
    /**
     * 日志操作人ID
     */
    @Column(name = "LOG_RECORD_OPERATION_ID")
    private String logRecordOperationId;
    /**
     * 日志来源系统
     */
    @Column(name = "LOG_RECORD_SYSTEM_NAME")
    private String logRecordSystemName;
    /**
     * 日志操作记录
     */
    @Column(name = "LOG_RECORD_OPERATION")
    private String logRecordOperation;
    /**
     * 操作端  0 ：用户端  1 : 管理端
     */
    @Column(name = "LOG_RECORD_SYS_USER")
    private Integer logRecordSysUser;

    public void setLogRecordOperationId(String logRecordOperationId) {
        this.logRecordOperationId = logRecordOperationId;
    }

    public void setLogRecordSystemName(String logRecordSystemName) {
        this.logRecordSystemName = logRecordSystemName;
    }

    public void setLogRecordOperation(String logRecordOperation) {
        this.logRecordOperation = logRecordOperation;
    }

    public void setLogRecordSysUser(Integer logRecordSysUser) {
        this.logRecordSysUser = logRecordSysUser;
    }

    public String getLogRecordOperationId() {
        return logRecordOperationId;
    }

    public String getLogRecordSystemName() {
        return logRecordSystemName;
    }

    public String getLogRecordOperation() {
        return logRecordOperation;
    }

    public Integer getLogRecordSysUser() {
        return logRecordSysUser;
    }

    public void setLogRecordId(String logRecordId) {
        this.logRecordId = logRecordId;
    }

    public void setLogRecordTypeId(String logRecordTypeId) {
        this.logRecordTypeId = logRecordTypeId;
    }

    public void setLogRecordComment(String logRecordComment) {
        this.logRecordComment = logRecordComment;
    }

    public void setLogRecordLevel(String logRecordLevel) {
        this.logRecordLevel = logRecordLevel;
    }

    public void setLogRecordCreateTime(Date logRecordCreateTime) {
        this.logRecordCreateTime = logRecordCreateTime;
    }

    public void setLogRecordState(Integer logRecordState) {
        this.logRecordState = logRecordState;
    }

    public void setLogRecordClient(Integer logRecordClient) {
        this.logRecordClient = logRecordClient;
    }

    public void setLogRecordOutPutFilepathId(String logRecordOutPutFilepathId) {
        this.logRecordOutPutFilepathId = logRecordOutPutFilepathId;
    }

    public String getLogRecordId() {
        return logRecordId;
    }

    public String getLogRecordTypeId() {
        return logRecordTypeId;
    }

    public String getLogRecordComment() {
        return logRecordComment;
    }

    public String getLogRecordLevel() {
        return logRecordLevel;
    }

    public Date getLogRecordCreateTime() {
        return logRecordCreateTime;
    }

    public Integer getLogRecordState() {
        return logRecordState;
    }

    public Integer getLogRecordClient() {
        return logRecordClient;
    }

    public String getLogRecordOutPutFilepathId() {
        return logRecordOutPutFilepathId;
    }
}
