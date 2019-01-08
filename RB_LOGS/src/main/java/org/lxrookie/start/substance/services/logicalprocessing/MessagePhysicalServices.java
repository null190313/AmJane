package org.lxrookie.start.substance.services.logicalprocessing;


/**
 *------------------------------.
 * @name : MessagePhysicalServices
 * @author : 沐惜
 * @createTime : 2018/12/3 16:52
 * @description : kafka返回json处理
 * @Version : 1.0
 *------------------------------
 */
public interface MessagePhysicalServices {

    /**
     *------------------------------.
     * @name : MessagePhysicalServices
     * @author : 沐惜
     * @Param : logRecordEntityJSON 消息实体JSON串   resultState发送状态
     * @Return : String
     * @createTime : 2018/12/3 17:44
     * @description : TODO
     * @Version : 1.0
     *------------------------------
     */
    public String messagePhysicalReturnJosnSuccess(String logRecordEntityJSON,String resultState);

}
