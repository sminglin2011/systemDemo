package com.sm.system.controller.account;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sm.system.domain.accountant.AccountReceivable;
import com.sm.system.domain.accountant.ChartOfAccount;
import com.sm.system.domain.accountant.JournalVoucher;
import com.sm.system.exception.MyException;
import com.sm.system.service.account.AccountReceivableService;
import com.sm.system.service.account.ChartOfAccountService;
import com.sm.system.service.account.GeneralLedgerService;
import com.sm.system.service.account.JournalVoucherService;
import com.sm.system.service.account.NumberCtrlService;

@Controller
public class ARController {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name="GeneralLedgerService")
	private GeneralLedgerService generalLedgerSvc;
	@Resource(name="coaService")
	private ChartOfAccountService coaSvc;
	@Resource(name="AccountReceivableService")
	private AccountReceivableService arSvc;
	@Resource(name="NumberCtrlService")
	private NumberCtrlService numberCtrlSvc;
	
	@RequestMapping("/accountReceivableMaster")
	private String accountReceivableMaster(Model model) throws MyException {
		log.debug("...... controller ......got all accountReceivable................");
		model.addAttribute("list", arSvc.findAll());
		return "system/account/accountReceivableMaster";
	}
	
	@RequestMapping("/accountReceivableAdd")
	private String accountReceivableAdd(Model model, String id) throws MyException {
		log.debug("...... controller ...... add accountReceivable ................ id =" + id);
		AccountReceivable ar = arSvc.findOne(id);
		model.addAttribute("ar", ar);
		return "system/account/accountReceivableAdd";
	}
	
	/**
	 * 保存 accountReceivable
	 * @param model
	 * @param ar
	 * @return
	 * @throws MyException
	 */
	@RequestMapping("/accountReceivableSave")
	@ResponseBody
	private String accountReceivableSave(Model model, AccountReceivable ar) throws MyException {
		log.debug(".......save accountReceivable ..........." + ar.getId());
		ar = arSvc.save(ar);
		return "ok";
	}
}
