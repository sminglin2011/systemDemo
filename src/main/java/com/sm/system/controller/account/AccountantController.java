package com.sm.system.controller.account;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sm.system.domain.accountant.ChartOfAccount;
import com.sm.system.domain.accountant.JournalVoucher;
import com.sm.system.exception.MyException;
import com.sm.system.service.account.ChartOfAccountService;
import com.sm.system.service.account.GeneralLedgerService;
import com.sm.system.service.account.JournalVoucherService;
import com.sm.system.service.account.NumberCtrlService;

@Controller
public class AccountantController {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name="GeneralLedgerService")
	private GeneralLedgerService generalLedgerSvc;
	@Resource(name="coaService")
	private ChartOfAccountService coaSvc;
	@Resource(name="JournalVoucherService")
	private JournalVoucherService jvSvc;
	@Resource(name="NumberCtrlService")
	private NumberCtrlService numberCtrlSvc;
	
	@RequestMapping("/journalVoucherMaster")
	private String journalVoucherMaster(Model model) throws MyException {
		log.debug("...... controller ......got all Journal Voucher................");
		model.addAttribute("list", jvSvc.findAll());
		return "system/account/journalVoucherMaster";
	}
	
	@RequestMapping("/journalVoucherAdd")
	private String journalVoucherAdd(Model model, String id) throws MyException {
		log.debug("...... controller ...... add journal voucher ................ id =" + id);
		JournalVoucher jv = jvSvc.findOne(id);
		model.addAttribute("jv", jv);
		return "system/account/journalVoucherAdd";
	}
	
	/**
	 * 保存 Journal Voucher
	 * @param model
	 * @param journal
	 * @return
	 * @throws MyException
	 */
	@RequestMapping("/journalVoucherSave")
	@ResponseBody
	private String journalVoucherSave(Model model, JournalVoucher journal) throws MyException {
		log.debug(".......save JournalVoucher ..........." + journal.getId());
		journal = jvSvc.save(journal);
		return "ok";
	}
	
	/**
	 * go in chart of account master
	 * @param model
	 * @return
	 * @throws MyException
	 */
	@RequestMapping("/chartOfAccountMaster")
	private String chartOfAccountMaster(Model model) throws MyException {
		log.debug("............got all COA................");
		model.addAttribute("coas", coaSvc.findAll());
		return "system/account/chartOfAccountMaster";
	}
	/**
	 * Patch System Default COA
	 * @param model
	 * @return
	 * @throws MyException
	 */
	@RequestMapping("/initCOA")
	@ResponseBody
	private String initCOA(Model model) throws MyException {
		coaSvc.initChartOfAccount();
		return "ok";
	}
	/**
	 * go to add chart of account page, if id != null then get COA entity
	 * @param model
	 * @param id
	 * @return
	 * @throws MyException 
	 */
	@RequestMapping("/chartOfAccountAdd")
	private String chartOfAccountAdd(Model model, String id) throws MyException {
		ChartOfAccount coa = new ChartOfAccount();
		if(id != null && !id.equals("0")){
			coa = coaSvc.findOne(id);
		}
		model.addAttribute("coa", coa);
		model.addAttribute("ledgerTypes", generalLedgerSvc.findAll());
		return "system/account/chartOfAccountAdd";
	}
	/**
	 * 保存 ChartOfAccount
	 * @param model
	 * @param coa
	 * @return
	 * @throws MyException
	 */
	@RequestMapping("/chartOfAccountSave")
	@ResponseBody
	private String chartOfAccountSave(Model model, ChartOfAccount coa) throws MyException {
		log.debug(".......save COA ..........." + coa.getId());
		coaSvc.save(coa);
		return "ok";
	}
	
	/**
	 * go to general ledger master
	 * @param model
	 * @return
	 * @throws MyException
	 */
	@RequestMapping("/generalLedgerMaster")
	private String generalLedgerMaster(Model model) throws MyException {
		log.debug("............got all general ledger................");
		model.addAttribute("generalLedgers", generalLedgerSvc.findAll());
		return "system/account/generalLedgerMaster";
	}

	/**
	 * save customization for general ledger name and sequence
	 * @param model
	 * @param id
	 * @param nameValue
	 * @param sequenceValue
	 * @return
	 * @throws MyException
	 */
	@RequestMapping("/saveGeneralLedger")
	@ResponseBody
	private String saveGeneralLedger(Model model, String id, String nameValue, String sequenceValue) throws MyException {
		log.debug(nameValue+"............save general ledger................"+sequenceValue);
		generalLedgerSvc.update(id, nameValue, sequenceValue);
		return "ok";
	}
}
