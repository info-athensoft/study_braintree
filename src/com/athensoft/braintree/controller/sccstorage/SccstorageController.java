package com.athensoft.braintree.controller.sccstorage;

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
import com.braintreegateway.ClientTokenRequest;
import com.braintreegateway.Customer;
import com.braintreegateway.CustomerRequest;
import com.braintreegateway.Environment;
import com.braintreegateway.Result;
import com.braintreegateway.Transaction;
import com.braintreegateway.TransactionRequest;

@Controller
public class SccstorageController {
	
	private static BraintreeGateway gateway = new BraintreeGateway(
	  Environment.SANDBOX,
	  "k3f73sfh3vf5vhdp",
	  "4h2yn56tdqzrc6nc",
	  "41b370e255158588ed75f406e4b74195"
	);
	
	@RequestMapping("sccstorage_form.do")
	public ModelAndView sccstorageForm(){
		ModelAndView mav = new ModelAndView();
		Map<String,Object> model = mav.getModel();
		
		//data
		ClientTokenRequest clientTokenRequest = new ClientTokenRequest().customerId("test2cust");
		String clientToken = gateway.clientToken().generate(clientTokenRequest);
		model.put("clientToken", clientToken);
		
		String viewName = "sccstorage/sccstorage_form";
		mav.setViewName(viewName);
		
		return mav;
	}
	
	@RequestMapping("sccstorage_result.do")
	public ModelAndView sccstorageResult(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView();		
		System.out.print("first_name:\t");
		String first_name = request.getParameter("first_name");
		System.out.println(first_name);
	
		System.out.print("year:\t");
		String year = request.getParameter("year");
		System.out.println(year);
		
		CustomerRequest customerRequest = new CustomerRequest()
                .firstName(request.getParameter("first_name"))
                .lastName(request.getParameter("last_name"))
                .creditCard()
                    .billingAddress()
                        .postalCode(request.getParameter("postal_code"))
                        .done()
                    .number(request.getParameter("number"))
        	        .cvv(request.getParameter("cvv"))
        	        .expirationMonth(request.getParameter("month"))
        	        .expirationYear(request.getParameter("year"))
                    .done();

            Result<Customer> result = gateway.customer().create(customerRequest);
            String strMsg = "";
            if (result.isSuccess()) {
            	strMsg =  "Customer created with name: " + result.getTarget().getFirstName() + " " + result.getTarget().getLastName();
              } else {

            	  strMsg =  "Error: " + result.getMessage();
              }
            
        Map<String,Object> data = mav.getModel();
        data.put("resultMessage", strMsg);
            
        String viewName = "sccstorage/sccstorage_result";
		mav.setViewName(viewName);
		return mav;
	}
}
