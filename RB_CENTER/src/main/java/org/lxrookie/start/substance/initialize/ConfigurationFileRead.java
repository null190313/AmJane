package org.lxrookie.start.substance.initialize;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigurationFileRead implements ApplicationContextInitializer {
    private static Map<Object,Object> contains = new HashMap<Object,Object>();
    private static Map<Object,Object> CONFIG_PROPERTIES_MAPS  = null;
    private static Properties p = null;
    private static final Logger logger = Logger.getLogger(ConfigurationFileRead.class);

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        getStaticConfigPropertiesFile();
        logger.info("=========================================>config.properties加载完成");
    }


    public static String getCOnfigValueByKey(String key){
        getStaticConfigPropertiesFile();
        return (String)CONFIG_PROPERTIES_MAPS.get(key) == null ? "" : (String)CONFIG_PROPERTIES_MAPS.get(key);
    }

    public static void getStaticConfigPropertiesFile(){
        if(null != CONFIG_PROPERTIES_MAPS){
            return;
        }else{
            try{
                p = new Properties();
                p.load(ConfigurationFileRead.class.getResourceAsStream("/config.properties"));
                CONFIG_PROPERTIES_MAPS = p;
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

}
