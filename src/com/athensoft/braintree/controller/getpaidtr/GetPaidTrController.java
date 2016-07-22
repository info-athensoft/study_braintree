package com.athensoft.braintree.controller.getpaidtr;

import com.braintreegateway.Request;
import java.math.BigDecimal;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.Environment;
import com.braintreegateway.Result;
import com.braintreegateway.Transaction;
import com.braintreegateway.TransactionRequest;

@Controller
public class GetPaidTrController {
	
	private static BraintreeGateway gateway = new BraintreeGateway(
	  Environment.SANDBOX,
	  "k3f73sfh3vf5vhdp",
	  "4h2yn56tdqzrc6nc",
	  "41b370e255158588ed75f406e4b74195"
	);
	
	@RequestMapping("getpaid_tr_result.do")
	public ModelAndView gotoGetPaidTrResult(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		
		Result<Transaction> result = gateway.transparentRedirect().confirmTransaction(request.getQueryString());
		String message = "";
        if (result.isSuccess()) {
            message = "Success: " + result.getTarget().getStatus().toString();
        } else {
            message = "Error: " + result.getMessage();
        }
        Map<String,Object> data = mav.getModel();
        data.put("resultMessage", message);
        
		String viewName = "getpaidtr/getpaid_tr_result";
		mav.setViewName(viewName);
		
		return mav;
	}
	
	@RequestMapping("getpaid_tr.do")
	public ModelAndView getPaidTr(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		
		String strAmt = "1000";//(String)request.getParameter("amt");
		String braintreeUrl = gateway.transparentRedirect().url();
		System.out.println("braintreeUrl:\t" + braintreeUrl);
		TransactionRequest transactionRequest = new TransactionRequest()
			.type(Transaction.Type.SALE)
	        .amount(new BigDecimal(strAmt))
	        .options()
	            .submitForSettlement(true)
	            .done();
	
		
		String trData = gateway.transparentRedirect().trData(transactionRequest, "http://localhost:8080/study_braintree/getpaid_tr_result.do");
		
        Map<String,Object> data = mav.getModel();
        data.put("braintreeUrl", braintreeUrl);
        data.put("trData", trData);
            
        String viewName = "getpaidtr/getpaid_tr_form";
		mav.setViewName(viewName);
		return mav;
	}
}
