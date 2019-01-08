package org.lxrookie.start.substance.services.obj;

import org.lxrookie.start.substance.entity.LogRecordEntity;
import org.lxrookie.start.substance.entity.LogRecordPathEntity;

import java.util.List;

/**
*------------------------------.
* @MethodName : LogRecordPathServices
* @author : 沐惜
* @createTime : 2018/11/26 20:56
* @description : TODO
* @Version : 1.0
*------------------------------
*/
public interface LogRecordPathServices {
    /**
    *------------------------------.
    * @MethodName : selectLogRecordPathListsByIds
    * @author : 沐惜
    * @param : logRecordPathEntities 实体参数
    * @return : List<LogRecordPathEntity>
    * @createTime : 2018/11/26 21:43
    * @description : TODO
    * @Version : 1.0
    *------------------------------
    */
    public List<LogRecordPathEntity> selectLogRecordPathListsByIds(List<LogRecordPathEntity> logRecordPathEntities);

    /**
     *------------------------------.
     * @MethodName : insertLogRecordPath
     * @author : 沐惜
     * @param :  logRecordPathEntity
     * @return :  插入对象主键
     * @createTime : 2018/11/26 21:00
     * @description : TODO
     * @Version : 1.0
     *------------------------------
     */
    public void insertLogRecordPath(LogRecordPathEntity logRecordPathEntity);

    /**
     *------------------------------.
     * @MethodName : closeLogRecordPath
     * @author : 沐惜
     * @param : logRecordPathEntity
     * @return :
     * @createTime : 2018/11/26 21:01
     * @description : 通过ID忽略日志
     * @Version : 1.0
     *------------------------------
     */
    public void closeLogRecordPath(LogRecordPathEntity logRecordPathEntity);
    
    
}
