package com.sm.system.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sm.system.domain.parameter.SystemParameter;
import com.sm.system.exception.MyException;
import com.sm.system.service.parameter.ParameterService;

@Controller
public class SystemParameterController {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name="ParameterServiceImpl")
	private ParameterService parameterSvc;

	@RequestMapping("/systemParameterMaster")
	private String systemParameterMaster(Model model){
		log.debug("......... got all parameters............");
		model.addAttribute("parameters", parameterSvc.findAll());
		return "system/parameter/master";
	}
	@RequestMapping("/saveParameter")
	@ResponseBody
	private String savaParameter(String id, String keyValue, Model model) throws MyException{
		log.debug("..........come in save parameter...... id = " + id + "....value=" + keyValue);
		parameterSvc.update(id, keyValue);
		return "ok";
	}
}
