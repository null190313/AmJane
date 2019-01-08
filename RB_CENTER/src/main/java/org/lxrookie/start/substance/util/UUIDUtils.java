package org.lxrookie.start.substance.util;



public class UUIDUtils {

    public static String uuid() {
        return java.util.UUID.randomUUID().toString().replaceAll("-", "");
    }
    public static String uuid40(){

        return java.util.UUID.randomUUID().toString().replaceAll("-", "")+java.util.UUID.randomUUID().toString().replaceAll("-", "").substring(0,8);
    }

}
