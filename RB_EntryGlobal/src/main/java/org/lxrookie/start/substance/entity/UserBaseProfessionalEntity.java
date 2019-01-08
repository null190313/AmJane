package org.lxrookie.start.substance.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 *------------------------------.
 * @name : UserBaseMessageProfessionalEntity
 * @author : 沐惜
 * @createTime : 2018/12/10 13:25
 * @description : 职业信息
 * @Version : 1.0
 *------------------------------
 */
@Table(name = "USER_BASE_PROFESSIONAL")
public class UserBaseProfessionalEntity {

    /**
     * 主键ID
     * */
    @Id
    @Column(name = "USER_PROFESSIONAL_ID")
    public String userProfessionalId;

    /**
     * 职业信息
     * */
    @Column(name = "USER_PROFESSIONAL")
    public String userProfessional;

    /**
     * 创建时间
     * */
    @Column(name = "USER_CREATE_TIME")
    public Date userCreateTime;

    /**
     * 启用状态
     * 0 启用
     * 1 禁用
     * */
    @Column(name = "USER_STATE")
    public Integer userState;

    public void setUserProfessionalId(String userProfessionalId) {
        this.userProfessionalId = userProfessionalId;
    }

    public void setUserProfessional(String userProfessional) {
        this.userProfessional = userProfessional;
    }

    public void setUserCreateTime(Date userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    public String getUserProfessionalId() {
        return userProfessionalId;
    }

    public String getUserProfessional() {
        return userProfessional;
    }

    public Date getUserCreateTime() {
        return userCreateTime;
    }

    public Integer getUserState() {
        return userState;
    }
}
