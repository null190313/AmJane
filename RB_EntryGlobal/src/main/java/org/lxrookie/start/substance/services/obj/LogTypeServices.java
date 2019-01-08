package org.lxrookie.start.substance.services.obj;/*
/*
 *------------------------------.
 * @MethodName : LogTypeServices
 * @author : 沐惜
 * @createTime : 2018/11/26 21:26
 * @description : TODO
 * @Version : 1.0
 *------------------------------
 */

import org.lxrookie.start.substance.entity.LogTypeEntity;

import java.util.List;

public interface LogTypeServices {
    /**
    *------------------------------.
    * @MethodName : selectLogTypeListsByIds
    * @author : 沐惜
    * @param : logTypeEntities
    *  @return : List<LogTypeEntity>
    * @createTime : 2018/11/26 21:28
    * @description : TODO
    * @Version : 1.0
    *------------------------------
    */
    public List<LogTypeEntity> selectLogTypeListsByIds(List<LogTypeEntity> logTypeEntities);



    /**
     *------------------------------.
     * @name : LogTypeServices
     * @author : 沐惜
     * @Param :
     * @Return :
     * @createTime : 2018/11/30 14:56
     * @description : TODO
     * @Version : 1.0
     *------------------------------
     */
     public LogTypeEntity selectLogTypeEntityByKey(String key);


    /**
    *------------------------------.
    * @MethodName : LogTypeServices
    * @author : 沐惜
    * @param :  logTypeEntity
    * @return :  String  插入主键
    * @createTime : 2018/11/26 21:29
    * @description : TODO
    * @Version : 1.0
    *------------------------------
    */
    public void insertLogType(LogTypeEntity logTypeEntity);


    /**
     *------------------------------.
     * @MethodName : closeLogRecord
     * @author : 沐惜
     * @param : logRecordEntity
     * @return :
     * @createTime : 2018/11/26 21:01
     * @description : 禁用日志类型
     * @Version : 1.0
     *------------------------------
     */
    public void closeLogType(LogTypeEntity logTypeEntity);
}
