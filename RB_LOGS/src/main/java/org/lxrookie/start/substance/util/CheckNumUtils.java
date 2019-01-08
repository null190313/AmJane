package org.lxrookie.start.substance.util;


/**
*------------------------------.
*@ClassName : CheckNumUtils
*@author : 沐惜
*@createTime : 2018/11/14 19:26
*@description : 唯一验证码
*@param :
 *@return :
*@Version : 1.0
*------------------------------
*/
public class CheckNumUtils {

	public static String createRandom(boolean numberFlag, int length) {
		String retStr = "";
		String strTable = numberFlag ? "1234567890"
				: "1234567890abcdefghijkmnpqrstuvwxyz";
		int len = strTable.length();
		boolean bDone = true;
		do {
			retStr = "";
			int count = 0;
			for (int i = 0; i < length; i++) {
				double dblR = Math.random() * len;
				int intR = (int) Math.floor(dblR);
				char c = strTable.charAt(intR);
				if (('0' <= c) && (c <= '9')) {
					count++;
				}
				retStr += strTable.charAt(intR);
			}
			if (count >= 2) {
				bDone = false;
			}
		} while (bDone);

		return retStr;
	}
}
