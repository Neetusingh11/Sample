package com.sp.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloMessageController {
	
	@Autowired
	private MessageSource msgSource;
	
	@GetMapping("/hello")
	public String helloErrorMessage() {
		
		return msgSource.getMessage("lable.error", null, LocaleContextHolder.getLocale());
	}

}
