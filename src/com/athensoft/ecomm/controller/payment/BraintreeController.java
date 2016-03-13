package com.athensoft.ecomm.controller.payment;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.ClientTokenRequest;
import com.braintreegateway.Environment;

@Controller
public class BraintreeController {
	
	private static BraintreeGateway gateway = new BraintreeGateway(
			  Environment.SANDBOX,
			  "k3f73sfh3vf5vhdp",
			  "4h2yn56tdqzrc6nc",
			  "41b370e255158588ed75f406e4b74195"
			);
	
	@RequestMapping("/client_token.do")
	public ModelAndView doCheckout() {
		System.out.println("entering client_token.do ...");
		
		ModelAndView mav = new ModelAndView();
		Map<String,Object> model = mav.getModel();
		
		//data
		ClientTokenRequest clientTokenRequest = new ClientTokenRequest().customerId("test2cust");
		String clientToken = gateway.clientToken().generate(clientTokenRequest);
		model.put("clientToken", clientToken);
		
		//view
		String viewName = "getpaid/braintree";
		mav.setViewName(viewName);
		
		System.out.println("exiting client_token.do ...");
		return mav;
	}
	
	@RequestMapping("/client_token_dropui.do")
	public ModelAndView doCheckout2() {
		System.out.println("entering client_token_dropui.do ...");
		
		ModelAndView mav = new ModelAndView();
		Map<String,Object> model = mav.getModel();
		
		//data
		ClientTokenRequest clientTokenRequest = new ClientTokenRequest().customerId("test2cust");
		String clientToken = gateway.clientToken().generate(clientTokenRequest);
		model.put("clientToken", clientToken);
		
		//view
		String viewName = "getpaid/braintree-dropui";
		mav.setViewName(viewName);
		
		System.out.println("exiting client_token_dropui.do ...");
		return mav;
	}
	
	@RequestMapping("/dropin.do")
	public ModelAndView doCheckout3() {
		System.out.println("entering dropin.do ...");
		
		ModelAndView mav = new ModelAndView();
		Map<String,Object> model = mav.getModel();
		
		//data
		ClientTokenRequest clientTokenRequest = new ClientTokenRequest().customerId("test2cust");
		String clientToken = gateway.clientToken().generate(clientTokenRequest);
		model.put("clientToken", clientToken);
		
		//view
		String viewName = "dropin";
		mav.setViewName(viewName);
		
		System.out.println("exiting client_token_dropui.do ...");
		return mav;
	}
}
