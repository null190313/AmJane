package org.lxrookie.start.substance.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
/**
 *------------------------------.
 * @name : SysTopicTubeEntity
 * @author : 沐惜
 * @createTime : 2018/12/2 17:44
 * @description : TODO
 * @Version : 1.0
 *------------------------------
 */
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
    private Integer sysTopicTubeStatus;
    /**
     * 创建时间
     */
    @Column(name = "SYS_TOPIC_TUBE_CREATE_TIME")
    private Date sysTopicTubeCreateTime;
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

    public void setSysTopicTubeStatus(Integer sysTopicTubeStatus) {
        this.sysTopicTubeStatus = sysTopicTubeStatus;
    }

    public void setSysTopicTubeCreateTime(Date sysTopicTubeCreateTime) {
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

    public Integer getSysTopicTubeStatus() {
        return sysTopicTubeStatus;
    }

    public Date getSysTopicTubeCreateTime() {
        return sysTopicTubeCreateTime;
    }

    public String getSysTopicTubeDescription() {
        return sysTopicTubeDescription;
    }
}
