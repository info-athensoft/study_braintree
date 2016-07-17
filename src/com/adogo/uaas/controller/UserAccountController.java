package com.adogo.uaas.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.adogo.uaas.entity.UserAccount;
import com.adogo.uaas.service.UserAccountService;

@Controller
public class UserAccountController {
	
	private static final Logger logger = Logger.getLogger(UserAccountController.class);
	
	
	private UserAccountService userAccountService;
	
	@Autowired
	public void setUserAccountService(UserAccountService userAccountService) {
		this.userAccountService = userAccountService;
	}


	@RequestMapping(value="/useracct",method=RequestMethod.GET)
	public ModelAndView getUserAccountAll(){
		logger.info("GET /useracct");
		ModelAndView mav = new ModelAndView();
		
		List<UserAccount> userAccountList = userAccountService.getUserAccountAll();
		logger.info(userAccountList.toString());
		
		Map<String,Object> data = mav.getModel();
		data.put("userAccountList", userAccountList);
		
		mav.setViewName("uaas/user-acct-list");
		return mav;
	}
	
	@RequestMapping(value="/useracct/{acctId}",method=RequestMethod.GET)
	public ModelAndView getUserAccount(@PathVariable long acctId){
		System.out.println("hello");
		ModelAndView mav = new ModelAndView();
		
		UserAccount userAccount = userAccountService.getUserAccount(acctId);
		
		logger.info(userAccount.toString());
		
		Map<String,Object> data = mav.getModel();
		data.put("userAccount", userAccount);
		
		mav.setViewName("uaas/test");
		return mav;
	}
	
	
	
	
//	@RequestMapping(value="/useracct/{acctId}",method=RequestMethod.GET)
//	@RequestMapping(value="/useracct1",method=RequestMethod.GET)
//	@RequestMapping("/useracct1")
//	public ModelAndView getUserAccount(@PathVariable long acctId){
	public ModelAndView getUserAccount111(long acctId){
		System.out.println("=======================");
		
		//logger.info("GET /useracct/"+acctId);
		ModelAndView mav = new ModelAndView();
		/*
		
		UserAccount userAccount = userAccountService.getUserAccount(acctId);
		logger.info(userAccount.toString());
		
		Map<String,Object> data = mav.getModel();
		data.put("userAccount", userAccount);
		*/
		mav.setViewName("uaas/user-acct");
		return mav;
	}
	
	
	
	
	
	
}
