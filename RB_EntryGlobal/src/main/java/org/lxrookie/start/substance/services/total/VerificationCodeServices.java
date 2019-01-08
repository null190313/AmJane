package org.lxrookie.start.substance.services.total;

/**
 *------------------------------.
 * @name : VerificationCodeServices
 * @author : 沐惜
 * @createTime : 2018/12/10 17:23
 * @description : redis操作验证码
 * @Version : 1.0
 *------------------------------
 */
public interface VerificationCodeServices {


    /**
     *------------------------------.
     * @name : VerificationCodeServices
     * @author : 沐惜
     * @Param : key redis key值
     * @Param : value redis value值
     * @Param : expireSecond redis key过期时间
     * @createTime : 2018/12/10 17:26
     * @description : 注册码存入Redis验证码
     * @Version : 1.0
     *------------------------------
     */
    public void depositRegisterCode(String key,Object value,Long expireSecond);




    /**
     *------------------------------.
     * @name : VerificationCodeServices
     * @author : 沐惜
     * @Param : phone  接收短信code的手机号
     * @Param :  短信模板ID
     * @Param :  code 发送到验证码
     * @Return : 发送成功的验证码
     * @return : 返回成功失败json字符串
     * @createTime : 2018/12/14 14:56
     * @description : 获取腾讯短信平台短信验证码  共6位数  5分钟内有效
     * @Version : 1.0
     *------------------------------
     */
    public String sendTencentMessageCode(String[] phone,int templateId,String[] code);

    /**
     *------------------------------.
     * @name : VerificationCodeServices
     * @author : 沐惜
     * @createTime : 2018/12/24 12:15
     * @description : 生成账号
     * @Version : 1.0
     *------------------------------
     */
    public String generateAccount();
}
