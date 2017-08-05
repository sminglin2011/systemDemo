package com.sm.system.util;

public class SystemUtil {

	/**
	 * 字符串数组转换成以','分开的拼接字符串
	 * @param args
	 * @return
	 */
	public static String stringArrayToString(String[] args) {
		StringBuffer sb = new StringBuffer();
		for (String str : args) {
			sb.append(str + ",");
		}
		sb.subSequence(0, sb.length()-1);
		return sb.toString();
	}
}
