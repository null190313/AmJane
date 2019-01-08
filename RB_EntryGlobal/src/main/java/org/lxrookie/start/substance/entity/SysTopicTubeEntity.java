package org.lxrookie.start.substance.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "SYS_TOPIC_TUBE")
public class SysTopicTubeEntity {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "SYS_TOPIC_TUBE_ID")
    private String sysTopicTubeId;
    /**
     * 对应topic的key
     */
    @Column(name = "SYS_TOPIC_TUBE_KEY")
    private String sysTopicTubeKey;
    /**
     * kafka   topic
     */
    @Column(name = "SYS_TOPIC_TUBE_VALUE")
    private String sysTopicTubeValue;
    /**
     * 0:开启
     * 1:关闭
     */
    @Column(name = "SYS_TOPIC_TUBE_STATUS")
    private String sysTopicTubeStatus;
    /**
     * 创建时间
     */
    @Column(name = "SYS_TOPIC_TUBE_CREATE_TIME")
    private String sysTopicTubeCreateTime;
    /**
     * topic描述
     */
    @Column(name = "SYS_TOPIC_TUBE_DESCRIPTION")
    private String sysTopicTubeDescription;


    public void setSysTopicTubeId(String sysTopicTubeId) {
        this.sysTopicTubeId = sysTopicTubeId;
    }

    public void setSysTopicTubeKey(String sysTopicTubeKey) {
        this.sysTopicTubeKey = sysTopicTubeKey;
    }

    public void setSysTopicTubeValue(String sysTopicTubeValue) {
        this.sysTopicTubeValue = sysTopicTubeValue;
    }

    public void setSysTopicTubeStatus(String sysTopicTubeStatus) {
        this.sysTopicTubeStatus = sysTopicTubeStatus;
    }

    public void setSysTopicTubeCreateTime(String sysTopicTubeCreateTime) {
        this.sysTopicTubeCreateTime = sysTopicTubeCreateTime;
    }

    public void setSysTopicTubeDescription(String sysTopicTubeDescription) {
        this.sysTopicTubeDescription = sysTopicTubeDescription;
    }

    public String getSysTopicTubeId() {
        return sysTopicTubeId;
    }

    public String getSysTopicTubeKey() {
        return sysTopicTubeKey;
    }

    public String getSysTopicTubeValue() {
        return sysTopicTubeValue;
    }

    public String getSysTopicTubeStatus() {
        return sysTopicTubeStatus;
    }

    public String getSysTopicTubeCreateTime() {
        return sysTopicTubeCreateTime;
    }

    public String getSysTopicTubeDescription() {
        return sysTopicTubeDescription;
    }
}
