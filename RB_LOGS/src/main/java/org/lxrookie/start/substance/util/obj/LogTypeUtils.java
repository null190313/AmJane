package org.lxrookie.start.substance.util.obj;

import com.ccb.openframework.util.FrameworkContext;
import org.lxrookie.start.substance.entity.LogTypeEntity;
import org.lxrookie.start.substance.services.obj.LogTypeServices;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *------------------------------.
 * @name : LogTypeUtils
 * @author : 沐惜
 * @createTime : 2018/11/30 15:04
 * @description : LogTypeUtils
 * @Version : 1.0
 *------------------------------
 */
public class LogTypeUtils {

    @Autowired
    private static LogTypeServices logTypeServices;


    public static LogTypeEntity getLogTypeEntityByKey(String key){
        LogTypeServices logTypeServices = (LogTypeServices)FrameworkContext.getApplicationContext().getBean("logTypeServices");
        LogTypeEntity logTypeEntity = logTypeServices.selectLogTypeEntityByKey(key);
        return logTypeEntity;
    }

}
