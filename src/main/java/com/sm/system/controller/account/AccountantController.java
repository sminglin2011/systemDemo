package com.sm.system.controller.account;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sm.system.exception.MyException;
import com.sm.system.service.account.GeneralLedgerService;

@Controller
public class AccountantController {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name="GeneralLedgerService")
	private GeneralLedgerService generalLedgerSvc;
	
	@RequestMapping("/generalLedgerMaster")
	private String generalLedgerMaster(Model model) throws MyException {
		log.debug("............got all general ledger................");
		model.addAttribute("generalLedgers", generalLedgerSvc.findAll());
		return "system/account/generalLedgerMaster";
	}

}
