package com.sm.system.controller.user;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sm.system.domain.parameter.SystemParameter;
import com.sm.system.domain.user.SystemUser;
import com.sm.system.exception.MyException;
import com.sm.system.service.parameter.ParameterService;
import com.sm.system.service.user.SystemUserService;

@Controller
public class UserController {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name="SystemUserServiceImpl")
	private SystemUserService userSvc;
	
	@InitBinder("user")    
	public void initBinder(WebDataBinder binder) {    
		binder.setFieldDefaultPrefix("user.");    
	}

	@RequestMapping("/user/userMaster")
	private String userMaster(Model model){
		log.debug("......get all user.......");
		model.addAttribute("users", userSvc.findAll());
		return "system/user/userMaster";
	}
	@RequestMapping("/user/userAdd")
	private String userAdd(Model model, String id){
		SystemUser user = userSvc.findOne(id);
		model.addAttribute("user", user == null? new SystemUser():user);
		return "system/user/userAdd";
	}
	
	@RequestMapping("/user/saveUser")
	@ResponseBody
	private String saveUser(Model model, SystemUser user) throws MyException{
		log.debug("..........come in save user...... ");
		userSvc.saveUser(user);
		log.debug("..........come in save user end...... ");
		return "ok";
	}
}
