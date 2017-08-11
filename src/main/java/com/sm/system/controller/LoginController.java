package com.sm.system.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sm.system.service.parameter.ParameterService;

@Controller
public class LoginController {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name="ParameterServiceImpl")
	private ParameterService parameterSvc;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	private String login() {
		log.debug("login debug");
		return "login";
	}
	
	@RequestMapping(value="/")
	private String index() {
		log.debug("index debug, check if initialization system parameter");
		if (parameterSvc.initParameter()) {
			return "/system/index";
		}
		return "initialization";
	}
	@RequestMapping(value="/index")
	private String index1() {
		return "/system/index";
	}
}
