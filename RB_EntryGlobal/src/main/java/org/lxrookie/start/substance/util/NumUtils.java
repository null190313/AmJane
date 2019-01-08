package org.lxrookie.start.substance.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;


/**
  *------------------------------.
  *@ClassName : NumUtils
  *@author : 沐惜
  *@createTime : 2018/11/14 19:31
  *@description : 数字格式化的类
  *@Version : 1.0
  *------------------------------
  */
public class NumUtils {


    /**
    *------------------------------.
    *@MethodName : keepRandomPoint
    *@author : 沐惜
    *@createTime : 2018/11/14 19:31
    *@description : 保留指定位数的小数(少的位数不补零)
    *@Version : 1.0
    *------------------------------
    */
    public static String keepRandomPoint(Double value, int n) {
        if (value == null) {
            value = 0.00;
            return new BigDecimal(value).setScale(n, RoundingMode.HALF_UP).toString();
        } else {
            return new BigDecimal(value).setScale(n, RoundingMode.HALF_UP).toString();
        }
    }


    /**
    *------------------------------.
    *@MethodName : keep2Point
    *@author : 沐惜
    *@createTime : 2018/11/14 19:31
    *@description : 浮点保留两位小数(少的位数不补零)
    *@Version : 1.0
    *------------------------------
    */
    public static String keep2Point(double value) {
        return keepRandomPoint(value, 2);
    }


    /**
    *------------------------------.
    *@MethodName : keep1Point
    *@author : 沐惜
    *@createTime : 2018/11/14 19:32
    *@description : 浮点保留1位小数(少的位数不补零)
    *@Version : 1.0
    *------------------------------
    */
    public static String keep1Point(double value) {
        return keepRandomPoint(value, 1);
    }


    /**
    *------------------------------.
    *@MethodName : keepRandomPointZero
    *@author : 沐惜
    *@createTime : 2018/11/14 19:32
    *@description : 浮点保留任意位小数(少位补零)
    *@Version : 1.0
    *------------------------------
    */
    public static String keepRandomPointZero(double value, int n) {
        DecimalFormat df = new DecimalFormat("#0.00");
        return df.format(Double.valueOf(keepRandomPoint(value, n)));
    }


    /**
    *------------------------------.
    *@MethodName : keep2PointZero
    *@author : 沐惜
    *@createTime : 2018/11/14 19:32
    *@description : 浮点保留两位小数(少位补零)
    *@Version : 1.0
    *------------------------------
    */
    public static String keep2PointZero(double value) {
        return keepRandomPointZero(value, 2);
    }


    /**
    *------------------------------.
    *@MethodName : percentRandomPoint
    *@author : 沐惜
    *@createTime : 2018/11/14 19:32
    *@description : 获取任意小数点位的百分比表示
    *@Version : 1.0
    *------------------------------
    */
    public static String percentRandomPoint(double value, int n) {
        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setGroupingUsed(false);
        percent.setMaximumFractionDigits(n);
        return percent.format(value);
    }


    /**
    *------------------------------.
    *@MethodName : percent2Point
    *@author : 沐惜
    *@createTime : 2018/11/14 19:32
    *@description : 百分比保留两位小数
    *@Version : 1.0
    *------------------------------
    */
    public static String percent2Point(double value) {
        return percentRandomPoint(value, 2);
    }

    /**
    *------------------------------.
    *@MethodName : latLngPoint
    *@author : 沐惜
    *@createTime : 2018/11/14 19:32
    *@description : 获取格式化经纬度后的小数(保留3位)
    *@Version : 1.0
    *------------------------------
    */
    public static String latLngPoint(double value) {
        return keepRandomPoint(value, 3);
    }

    /**
     *------------------------------.
     * @name : NumUtils
     * @author : 沐惜
     * @createTime : 2018/12/24 12:10
     * @description : 生成6位随机验证码
     * @Version : 1.0
     *------------------------------
     */
    public static String pickBitsRandom(){
        String[] bitsRandom = new String[6];
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 6; i++) {
               // bitsRandom[i] =String.valueOf((int)((Math.random()*9+1)));
                stringBuffer.append((int)((Math.random()*9+1)));
        }
        return stringBuffer.toString();
    }
    /**
     *------------------------------.
     * @name : NumUtils
     * @author : 沐惜
     * @createTime : 2018/12/24 12:14
     * @description : 去时间戳后八位
     * @Version : 1.0
     *------------------------------
     */
    public static String generateAccount(){
        long timeStamp = System.currentTimeMillis();
        String timeStampStr = String.valueOf(timeStamp).substring(String.valueOf(timeStamp).length()-8,String.valueOf(timeStamp).length());
        return timeStampStr;
    }

}
