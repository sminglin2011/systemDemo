package com.sm.system.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sm.system.constant.StaticParams;
import com.sm.system.domain.parameter.SystemParameter;
import com.sm.system.service.parameter.ParameterService;

@Controller
public class InitializationSystemController {

	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "ParameterServiceImpl")
	private ParameterService parameterSvc;

	@RequestMapping("/initSys")
	private String initSystem(Model model, HttpServletRequest request) {
		log.debug("...........................begin initialization system parameter............................");
		parameterSvc.deleteAll();
		List<SystemParameter> parameters = new ArrayList<>();
		SystemParameter parameter = null;
		Map<String, String[]> params = request.getParameterMap();
		for (String keyname : StaticParams.SYSTEM_PARAMETER_KEYS) {
			log.debug("keyname=" + keyname.replace("-", "").toLowerCase());
			/**
			 * keyType = {String, boolean}
			 */
			boolean onInitPage = false;
			for (String paramkey : params.keySet()) {
				log.debug("paramkey=" + paramkey.toLowerCase());
				if (paramkey.toLowerCase().equals(keyname.replace("-", "").toLowerCase())) {
					String[] values = params.get(paramkey);
					StringBuffer sb = new StringBuffer();
					for (String str : values) {
						sb.append(str);
					}
					// parameter = new SystemParameter(keyName, keyType,
					// keyLenght, keyValue, comments);
					parameter = new SystemParameter(keyname, "String", "50", sb.toString(), "");
					onInitPage = true;
					continue;
				}
			}
			if (!onInitPage) {
				parameter = new SystemParameter(keyname, "String", "50", "", "");
			}
			parameters.add(parameter);
		}

		parameterSvc.save(parameters);
		return "redirect:/index";
	}

}
