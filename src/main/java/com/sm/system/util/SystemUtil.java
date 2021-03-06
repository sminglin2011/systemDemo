package com.sm.system.util;

import java.security.InvalidKeyException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

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
	
	private static final String date_format = "yyyy-MM-dd"; //yyyy-MM-dd HH:mm:ss
    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>(); 
 
    public static DateFormat getDateFormat()   
    {  
        DateFormat df = threadLocal.get();  
        if(df==null){  
            df = new SimpleDateFormat(date_format);  
            threadLocal.set(df);  
        }  
        return df;  
    }
    public static DateFormat getDateFormat(String dateFormat)   
    {  
        DateFormat df = threadLocal.get();  
        if(df==null){  
            df = new SimpleDateFormat(dateFormat);  
            threadLocal.set(df);  
        }  
        return df;  
    }

    public static String formatDate(Date date) throws ParseException {
        return getDateFormat().format(date);
    }

    public static Date parse(String strDate) throws ParseException{
        return getDateFormat().parse(strDate);
    }
    /**
     * Date convert to dateFormat
     * @param date
     * @param dateFormat
     * @return
     * @throws ParseException
     */
    public static String formatDate(Date date, String dateFormat) throws ParseException {
        return getDateFormat(dateFormat).format(date);
    }
    
    /**
     * check empty
     * @param st
     * @return
     */
    public static boolean isEmpty(String st) {
    	if (st == null || st.equals("null") || st.equals("") || st.equals("0")) {
    		return true;
    	}
    	return false;
    }
    
    /**
     * 加密
     * @param key
     * @return
     * @throws Exception
     */
    public static String desEncrypt(String key) throws Exception {
    	Aes des = new Aes("sming"); //自定义密钥
    	System.out.println("加密后的字符：" + des.encrypt(key));
    	key = des.encrypt(key);
    	return key;
    }
    
    /**
     * 解密
     * @param key
     * @return
     * @throws Exception
     */
    public static String desDecrypt(String key) throws Exception {
    	Aes des = new Aes("sming"); //自定义密钥
    	key = des.decrypt(key);
    	System.out.println("解密后的字符：" + key);
    	return key.toString();
    }
}
