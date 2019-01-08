package org.lxrookie.start.substance.services.obj;

import org.lxrookie.start.substance.entity.LogRecordEntity;

import java.util.List;

/**
*------------------------------.
* @Name : LogRecordServices
* @author : 沐惜
* @createTime : 2018/11/26 20:58
* @description : TODO
* @Version : 1.0
*------------------------------
*/
public interface LogRecordServices {

    /**
    *------------------------------.
    * @MethodName : selectLogRecordListsById
    * @author : 沐惜
    * @param :  ids
    *  *@return :
    * @createTime : 2018/11/26 20:59
    * @description : 查询LogRecord日志对象
    * @Version : 1.0
    *------------------------------
    */
    public LogRecordEntity selectLogRecordListsById(String id);

    /**
    *------------------------------.
    * @MethodName : insertLogRecord
    * @author : 沐惜
    * @param :  logRecordEntity
    *  *@return :  插入对象主键
    * @createTime : 2018/11/26 21:00
    * @description : TODO
    * @Version : 1.0
    *------------------------------
    */
    public void insertLogRecord(LogRecordEntity logRecordEntity);

    /**
    *------------------------------.
    * @MethodName : closeLogRecord
    * @author : 沐惜
    * @param : logRecordEntity
    *  *@return :
    * @createTime : 2018/11/26 21:01
    * @description : 通过ID忽略日志
    * @Version : 1.0
    *------------------------------
    */
    public void closeLogRecord(LogRecordEntity logRecordEntity);

    /**
     *------------------------------.
     * @name : LogRecordServices
     * @author : 沐惜
     * @Param : logRecordEntity实体的json串
     * @Return : void
     * @createTime : 2018/12/3 17:48
     * @description : 需要toBean转换实体   在进行插入
     * @Version : 1.0
     *------------------------------
     */
    public void insertLogRecordTheStack(String logRecordEntityJSON);

}
