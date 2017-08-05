package com.sm.system.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class StaticParams {
	
	public static Collection<String> CLASSIFICATIONS = new ArrayList<String>
	(Arrays.asList("ASSETS", "COST-OF-GOODS-SOLD", "EQUITY", "EXPENSES", "LIABILITY", "SALES", "GROSS-PROFIT"));

	
	public static String[] SYSTEM_PARAMETER_KEYS = {
			  "COMPANY-NAME"
			, "COMPANY-ADDRESS"
			, "COMPANY-POSTAL"
			, "COMPANY-COUNTRY"
			, "COMPANY-TEL"
			, "COMPANY-FAX"
			
			, "JOURNAL-VOUCHER-NUMBER-PREFIX"
			, "ACCOUNT-RECEIVABLE-NUMBER-PREFIX"
			, "RECEIPT-VOUCHER-NUMBER-PREFIX"
			, "ACCOUNT-PAYABLE-NUMBER-PREFIX"
			, "PAYMENT-VOUCHER-NUMBER-PREFIX"
	};
}
