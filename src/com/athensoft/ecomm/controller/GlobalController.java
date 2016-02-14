package com.athensoft.ecomm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GlobalController {
	
	@RequestMapping("/test.do")
	public String gotoTest(){
		return "test";
	}
}
