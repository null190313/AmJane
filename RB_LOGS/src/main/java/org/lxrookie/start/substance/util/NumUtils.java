package org.lxrookie.start.substance.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;


/**
*------------------------------.
*@ClassName : NumUtils
*@author : 沐惜
*@createTime : 2018/11/14 19:31
*@description : 数字格式化的类
*@param :
 *@return :
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
      *@param :
      *@return :
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
      *@param :
      *@return :
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
      *@param :
      *@return :
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
      *@param :
      *@return :
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
      *@param :
      *@return :
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
      *@param :
      *@return :
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
      *@param :
      *@return :
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
      *@param :
      *@return :
      *@Version : 1.0
      *------------------------------
      */
    public static String latLngPoint(double value) {
        return keepRandomPoint(value, 3);
    }

}
