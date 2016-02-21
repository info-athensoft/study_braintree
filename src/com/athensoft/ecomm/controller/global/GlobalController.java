package com.athensoft.ecomm.controller.global;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GlobalController {
	
	@RequestMapping("/test.do")
	public String gotoTest(){
		return "test";
	}
	
	@RequestMapping("/checkout.do")
	public String gotoCheckout(){
		System.out.println("entering checkout.do ...");
		return "checkout";
	}
		
}
