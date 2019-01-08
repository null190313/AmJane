package org.lxrookie.start.substance.entity;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * ------------------------------.
 *
 * @author : 沐惜
 * @name : UserBaseMassage
 * @createTime : 2018/12/3 10:57
 * @description : 用户(服务端Client)实体类
 * @Version : 1.0
 * ------------------------------
 */
@Table(name = "USER_BASE_MESSAGE")
public class UserBaseMessageEntity {

    /**
     * 用户ID
     */
    @Id
    @Column(name = "USERID")
    private String userId;

    /**
     * 用户真实姓名
     **/
    @Column(name = "USER_REALNAME")
    private String userRealName;

    /**
     * 用户注册成功生成账号
     */
    @Column(name = "USER_ACCOUNT")
    public String userAccount;

    /**
     * 用户密码
     */
    @Column(name = "USER_PASSWORD")
    public String userPasword;


    /**
     * 用户注册昵称
     **/
    @Column(name = "USER_NICKNAME")
    private String userNickName;

    /**
     * 用户注册邮箱
     **/
    @Column(name = "USER_EAMIL")
    private String userEamil;

    /**
     * 用户注册手机
     **/
    @Column(name = "USER_PHONE")
    private String userPhone;


    /**
     * 用户注册时间
     **/
    @Column(name = "USER_CREATETIME")
    private Date userCreateTime;

    /**
     * 注册类型：
     * 1：网站注册     PC端
     * 2: 快捷登录(QQ) PC端
     * 3: 快捷登录(WX) PC端
     * 4: 快捷登录(BD) PC端
     * 5：APP注册      APP端
     * 6: 快捷登录(QQ) APP端
     * 7: 快捷登录(WX) APP端
     * 8: 快捷登录(BD) APP端
     **/
    @Column(name = "USER_TYPE")
    private Integer userType;

    /**
     * 用户地址
     **/
    @Column(name = "USER_ADDRESS")
    private String userAddress;

    /**
     * 用户省份
     **/
    @Column(name = "USER_PROVINCE")
    private String userProvince;

    /**
     * 用户所在市
     **/
    @Column(name = "USER_CITY")
    private String userCity;

    /**
     * 用户所在县
     **/
    @Column(name = "USER_COUNTY")
    private String userCounty;

    /**
     * 用户QQ号
     **/
    @Column(name = "USER_QQ_NUM")
    private String userQQNum;

    /**
     * 用户微信号
     **/
    @Column(name = "USER_WX_NUM")
    private String userWXNum;

    /**
     * 用户身份证号
     **/
    @Column(name = "USER_IDCARD")
    private String userIDCard;

    /**
     * 用户当前账号封禁状态
     * 0:未封禁
     * 1:已封禁
     **/
    @Column(name = "USER_BANNED_STATE")
    private String userBannedState;

    /**
     * 用户会员积分值
     **/
    @Column(name = "USER_INTEGRAL")
    private Integer userIntegral;

    /**
     * 用户性别
     * 0:男
     * 1:女
     * 2:保密
     **/
    @Column(name = "USER_SEX")
    private Integer userSex;

    /**
     * QQ第三方登录unionid
     **/
    @Column(name = "USER_QQ_ID")
    private String userQQId;

    /**
     * WX第三方登录unionid
     **/
    @Column(name = "USER_WX_ID")
    private String userWXId;
    /**
     * 百度第三方登录unionid
     **/
    @Column(name = "USER_BD_ID")
    private String userBDId;

    /**
     * 用户是否实名
     * 0:未实名
     * 1:已实名
     **/
    @Column(name = "USER_REAL_NAME_STATE")
    private Integer userRealNameState;

    /**
     * 最后一次登录时间
     **/
    @Column(name = "USER_LAST_LOGIN_TIME")
    private Date userLastLoginTime;

    /**
     * 职业
     **/
    @Column(name = "USER_PROFESSIONAL")
    private String userProfessional;

    /**
     * 头像url
     */
    @Column(name = "USER_HEAD_PIC_URL")
    private String userHeadPicUrl;

    /**
     * 用户生日
     */
    @Column(name = "USER_BIRTHDAY")
    private Date userBirthday;

    /**
     * 用户身份
     * 1:学生
     * 2:职场人
     */
    @Column(name = "USER_IDENTITY")
    private Integer userIdentity;

    /**
     * 用户简介
     * */
    @Column(name = "USER_INTRODUCTION")
    private String userIntroduction;

    /**
     * 用户第二次输入密码  未持久化  仅注册使用
     */
    @Transient
    public String userSecondPassword;

    /**
     * 用户注册登录手机验证码校验  未持久化
     */
    @Transient
    public String userDetectionCode;


    public void setUserIntroduction(String userIntroduction) {
        this.userIntroduction = userIntroduction;
    }

    public void setUserIdentity(Integer userIdentity) {
        this.userIdentity = userIdentity;
    }

    public Integer getUserIdentity() {
        return userIdentity;
    }

    public String getUserIntroduction() {
        return userIntroduction;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserHeadPicUrl(String userHeadPicUrl) {
        this.userHeadPicUrl = userHeadPicUrl;
    }

    public String getUserHeadPicUrl() {
        return userHeadPicUrl;
    }

    public void setUserProfessional(String userProfessional) {
        this.userProfessional = userProfessional;
    }

    public String getUserProfessional() {
        return userProfessional;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public void setUserPasword(String userPasword) {
        this.userPasword = userPasword;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public String getUserPasword() {
        return userPasword;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public void setUserEamil(String userEamil) {
        this.userEamil = userEamil;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public void setUserCreateTime(Date userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public void setUserProvince(String userProvince) {
        this.userProvince = userProvince;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public void setUserCounty(String userCounty) {
        this.userCounty = userCounty;
    }

    public void setUserQQNum(String userQQNum) {
        this.userQQNum = userQQNum;
    }

    public void setUserWXNum(String userWXNum) {
        this.userWXNum = userWXNum;
    }

    public void setUserIDCard(String userIDCard) {
        this.userIDCard = userIDCard;
    }

    public void setUserBannedState(String userBannedState) {
        this.userBannedState = userBannedState;
    }

    public void setUserIntegral(Integer userIntegral) {
        this.userIntegral = userIntegral;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public void setUserQQId(String userQQId) {
        this.userQQId = userQQId;
    }

    public void setUserWXId(String userWXId) {
        this.userWXId = userWXId;
    }

    public void setUserBDId(String userBDId) {
        this.userBDId = userBDId;
    }

    public void setUserRealNameState(Integer userRealNameState) {
        this.userRealNameState = userRealNameState;
    }

    public void setUserLastLoginTime(Date userLastLoginTime) {
        this.userLastLoginTime = userLastLoginTime;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public String getUserEamil() {
        return userEamil;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public Date getUserCreateTime() {
        return userCreateTime;
    }

    public Integer getUserType() {
        return userType;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public String getUserProvince() {
        return userProvince;
    }

    public String getUserCity() {
        return userCity;
    }

    public String getUserCounty() {
        return userCounty;
    }

    public String getUserQQNum() {
        return userQQNum;
    }

    public String getUserWXNum() {
        return userWXNum;
    }

    public String getUserIDCard() {
        return userIDCard;
    }

    public String getUserBannedState() {
        return userBannedState;
    }

    public Integer getUserIntegral() {
        return userIntegral;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public String getUserQQId() {
        return userQQId;
    }

    public String getUserWXId() {
        return userWXId;
    }

    public String getUserBDId() {
        return userBDId;
    }

    public Integer getUserRealNameState() {
        return userRealNameState;
    }

    public Date getUserLastLoginTime() {
        return userLastLoginTime;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserSecondPassword(String userSecondPassword) {
        this.userSecondPassword = userSecondPassword;
    }

    public String getUserSecondPassword() {
        return userSecondPassword;
    }

    public void setUserDetectionCode(String userDetectionCode) {
        this.userDetectionCode = userDetectionCode;
    }

    public String getUserDetectionCode() {
        return userDetectionCode;
    }

}
