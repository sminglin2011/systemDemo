package com.sm.system.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StaticParams {
	
	
	public static Collection<String> CLASSIFICATIONS = new ArrayList<String>
	(Arrays.asList("ASSETS", "COST-OF-GOODS-SOLD", "EQUITY", "EXPENSES", "LIABILITY", "SALES")); //, "GROSS-PROFIT"

	private static  Collection<String[]> SYSTEMPARAMETER() {
		Collection<String[]> a = new ArrayList<>();
		a.add(new String[]{"COMPANY-NAME","String","50"});
		a.add(new String[]{"COMPANY-POSTAL","String","50"});
		a.add(new String[]{"COMPANY-COUNTRY","String","50"});
		a.add(new String[]{"COMPANY-TEL","String","50"});
		a.add(new String[]{"COMPANY-FAX","String","50"});
		
		a.add(new String[]{"JOURNAL-VOUCHER-NUMBER-PREFIX","String","50"});
		a.add(new String[]{"ACCOUNT-RECEIVABLE-NUMBER-PREFIX","String","50"});
		a.add(new String[]{"RECEIPT-VOUCHER-NUMBER-PREFIX","String","50"});
		a.add(new String[]{"ACCOUNT-PAYABLE-NUMBER-PREFIX","String","50"});
		a.add(new String[]{"PAYMENT-VOUCHER-NUMBER-PREFIX","String","50"});
		
		a.add(new String[]{"ACCOUNT-NUMBER-PATTERN","String","50"});
		a.add(new String[]{"ACCOUNT-NUMBER-LENGTH","String","50"});
		
		a.add(new String[]{"SYSTEM_CURRENCY","String","50"});
		
		/**
		 * SMSYSTEM_开头的parameter只有在初始化页面才能输入，修改都不保存，所以在parameter EDIT时要做条件判断
		 */
		a.add(new String[]{"SMSYSTEM_USER_QUANTITY","String","50"});
		
		return a;
    }
	public static Collection<String[]> SYSTEM_PARAMETER_KEYS = SYSTEMPARAMETER();
	
//	public static String[] SYSTEM_PARAMETER_KEYS = {
//			  "COMPANY-NAME"
//			, "COMPANY-ADDRESS"
//			, "COMPANY-POSTAL"
//			, "COMPANY-COUNTRY"
//			, "COMPANY-TEL"
//			, "COMPANY-FAX"
//			
//			, "JOURNAL-VOUCHER-NUMBER-PREFIX"
//			, "ACCOUNT-RECEIVABLE-NUMBER-PREFIX"
//			, "RECEIPT-VOUCHER-NUMBER-PREFIX"
//			, "ACCOUNT-PAYABLE-NUMBER-PREFIX"
//			, "PAYMENT-VOUCHER-NUMBER-PREFIX"
//			
//			, "ACCOUNT-NUMBER-PATTERN"
//			, "ACCOUNT-NUMBER-LENGTH"
//	};
	
	public static String DATEFORMAT_YYYY = "yyyy";
	public static String DATEFORMAT_YYYYMM = "yyyyMM";
	public static String DATEFORMAT_YYMM = "yyMM";
	public static String DATEFORMAT_YYYY_MM_DD = "yyyy-MM-dd";
	public static String DATEFORMAT_YYYY_MM_DD_TIME = "yyyy-MM-dd HH:mm:ss";
	
}
