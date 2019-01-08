package org.lxrookie.start.substance.entity;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 *------------------------------.
 *@ClassName : LogRecordPath
 *@author : 沐惜
 *@createTime : 2018/11/26 19:25
 *@描述 : 日志输入路径
 *@Version : 1.0
 *------------------------------
 */
@Table(name = "LOG_RECORD_PATH")
public class LogRecordPathEntity {

    /**
     *  日志内容输出文件ID
     */
    @Id
    @Column(name = "LOG_RECORD_PATH_ID")
    private String logRecordPathId;

    /**
     *  日志内容输出文件名称
     */
    @Column(name = "LOG_RECORD_PATH_FILENAME")
    private String logRecordPathFileName;

    /**
     *   日志内容输出文件路径
     */
    @Column(name = "LOG_RECORD_PATH_FILEPATH")
    private String logRecordPathFilePath;

    /**
     *  日志目录输出文件createTime
     */
    @Column(name = "LOG_RECORD_CREATE_TIME")
    private Date logRecordPathCreateTime;


    public void setLogRecordPathId(String logRecordPathId) {
        this.logRecordPathId = logRecordPathId;
    }

    public void setLogRecordPathFileName(String logRecordPathFileName) {
        this.logRecordPathFileName = logRecordPathFileName;
    }

    public void setLogRecordPathFilePath(String logRecordPathFilePath) {
        this.logRecordPathFilePath = logRecordPathFilePath;
    }

    public void setLogRecordPathCreateTime(Date logRecordPathCreateTime) {
        this.logRecordPathCreateTime = logRecordPathCreateTime;
    }

    public String getLogRecordPathId() {
        return logRecordPathId;
    }

    public String getLogRecordPathFileName() {
        return logRecordPathFileName;
    }

    public String getLogRecordPathFilePath() {
        return logRecordPathFilePath;
    }

    public Date getLogRecordPathCreateTime() {
        return logRecordPathCreateTime;
    }
}
