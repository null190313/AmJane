package org.lxrookie.start.substance.services;

/**
 *------------------------------.
 * @name : UserCustomerOperationTopicServices
 * @author : 沐惜
 * @createTime : 2018/12/3 9:41
 * @description : TODO
 * @Version : 1.0
 *------------------------------
 */
public interface UserCustomerOperationTopicServices {
        /**
         *------------------------------
         * @name : UserCustomerOperationTopicServices
         * @author : 沐惜
         * @Param : String  logRecordJson   logRecordEntity实体
         * @Return : messgae{
         *            status    :  状态码
         *           newsResult : success(error)
         * }
         * @createTime : 2018/12/3 10:12
         * @description : 封装USER_CUSTOMER_OPERATION_TOPIC消息
         * @Version : 1.0
         *------------------------------
         */
        public String theUserLoginInToRegisterOperation(String logRecordEntityJson);

}
