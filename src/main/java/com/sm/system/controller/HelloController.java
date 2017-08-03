package com.sm.system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sm.system.exception.MyException;

@Controller
public class HelloController {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	
	
//	@RequestMapping(value="/")
//	private String index() {
//		log.debug("index debug");
//		return "index";
//	}
	@RequestMapping("/testError")
	private String testException() throws MyException {
		throw new MyException("test error");
	}
	
	@RequestMapping("/testError1")
	private String testException1() throws Exception {
		throw new Exception("test error");
	}

}
