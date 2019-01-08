package org.lxrookie.start.substance.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *------------------------------.
 *@ClassName : MD5Utils
 *@author : 沐惜
 *@createTime : 2018/11/14 19:30
 *@description : TODO
 *@param :
 *@return :
 *@Version : 1.0
 *------------------------------
 */
public class MD5Utils {

	/** 全局数组 **/
	private final static String[] STRDIGITS = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };


	/**
	 *------------------------------.
	 *@MethodName : MD5Utils
	 *@author : 沐惜
	 *@createTime : 2018/11/14 19:30
	 *@description : 返回形式为数字跟字符串
	 *@param : bByte
	 *@return :
	 *@Version : 1.0
	 *------------------------------
	 */
	private static String byteToArrayString(byte bByte) {
		int iRet = bByte;
		if (iRet < 0) {
			iRet += 256;
		}
		int iD1 = iRet / 16;
		int iD2 = iRet % 16;
		return STRDIGITS[iD1] + STRDIGITS[iD2];
	}


	/**
	 *------------------------------.
	 *@MethodName : MD5Utils
	 *@author : 沐惜
	 *@createTime : 2018/11/14 19:30
	 *@description : 转换字节数组为16进制字串
	 *@param : bByte
	 *@return :
	 *@Version : 1.0
	 *------------------------------
	 */
	private static String byteToString(byte[] bByte) {
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < bByte.length; i++) {
			sBuffer.append(byteToArrayString(bByte[i]));
		}
		return sBuffer.toString();
	}


	/**
	 *------------------------------.
	 *@MethodName : MD5Utils
	 *@author : 沐惜
	 *@createTime : 2018/11/14 19:31
	 *@description : MD5加密
	 *@param : str  待加密的字符串
	 *@return :
	 *@Version : 1.0
	 *------------------------------
	 */
	public static String getMD5Code(String str) {
		String result = null;
		try {
			result = new String(str);
			MessageDigest md = MessageDigest.getInstance("MD5");
			result = byteToString(md.digest(str.getBytes()));
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return result;
	}


	/**
	 *------------------------------.
	 *@MethodName : MD5Utils
	 *@author : 沐惜
	 *@createTime : 2018/11/14 19:31
	 *@description : MD5加密
	 *@param : str 待加密的字符串 lowerCase 大小写
	 *@return :
	 *@Version : 1.0
	 *------------------------------
	 */
	public static String getMD5Code(String str, boolean lowerCase) {
		String result = null;
		try {
			result = new String(str);
			MessageDigest md = MessageDigest.getInstance("MD5");
			result = byteToString(md.digest(str.getBytes()));
			if (lowerCase) {
				result = result.toLowerCase();
			}
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return result;
	}

}
