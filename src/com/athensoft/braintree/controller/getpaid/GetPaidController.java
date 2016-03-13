package com.athensoft.braintree.controller.getpaid;

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
public class GetPaidController {
	
	private static BraintreeGateway gateway = new BraintreeGateway(
	  Environment.SANDBOX,
	  "k3f73sfh3vf5vhdp",
	  "4h2yn56tdqzrc6nc",
	  "41b370e255158588ed75f406e4b74195"
	);
	
	@RequestMapping("braintree.do")
	public ModelAndView gotoBraintree(){
		ModelAndView mav = new ModelAndView();
		
		String viewName = "getpaid/braintree";
		mav.setViewName(viewName);
		
		return mav;
	}
	
	@RequestMapping("create_transaction.do")
	public ModelAndView createTransaction(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		
		
		//test
		System.out.print("payment_method_nonce:\t");
		System.out.println((String)request.getParameter("payment_method_nonce"));
		
		System.out.print("amt:\t");
		String strAmt = (String)request.getParameter("amt");
		System.out.println(strAmt);
		
		//data		
		TransactionRequest transactionRequest = new TransactionRequest()
	        .amount(new BigDecimal(strAmt))
//	        .paymentMethodToken("ft7sgr")	//by token at vault
	        .customerId("test2cust")	//by token at vault
	        .creditCard()
	            .number(request.getParameter("number"))
	            .cvv(request.getParameter("cvv"))
	            .expirationMonth(request.getParameter("month"))
	            .expirationYear(request.getParameter("year"))
	            .done()
	        .options()
	            .submitForSettlement(true)
	            .done();
	
	    Result<Transaction> result = gateway.transaction().sale(transactionRequest);
	    
	    boolean isSuccess = result.isSuccess();
	    String resultMessage = "";
	    if(isSuccess){
	    	System.out.println("Success");
	    	resultMessage = "Success ID:"+result.getTarget().getId();
	    }else{
	    	System.out.println("Failed");
	    	resultMessage = result.getMessage();
	    }
	    
	    //test payment method
//	    String vaultToken = "ft7sgr";
//	    PaymentMethod paymentMethod = gateway.paymentMethod().find(vaultToken);
//	    System.out.println(paymentMethod.getToken());
//	    System.out.println(paymentMethod instanceof CreditCard);
	    
	    //System.out.println("payment_method_nonce:"+request.getParameter("paymentMethodNonce"));
	    
	    
	    
	    
	    //System.out.println("all params:\n"+request.getParameterNames());
		
        Map<String,Object> data = mav.getModel();
        data.put("resultMessage", resultMessage);
            
        String viewName = "getpaid/result";
		mav.setViewName(viewName);
		return mav;
	}
}
