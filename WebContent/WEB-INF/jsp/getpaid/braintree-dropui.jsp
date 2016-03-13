<%@ page contentType="text/html; charset=utf-8" %>
<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
  <head>
  </head>
  <body>
    <h1>Braintree Credit Card Transaction Form</h1>
    <div>
      <form action="create_transaction.do" method="POST" id="checkout">
        <div id="payment-form"></div>
        <input type="submit" value="Pay $10" />
      </form>
    </div>
    <script type="text/javascript" src="https://js.braintreegateway.com/v1/braintree.js"></script>
    <script type="text/javascript">
    	var clientToken = "<c:out value='${clientToken}'/>";
        var braintree = Braintree.create(clientToken);
        
        braintree.setup(clientToken, 'dropin', {
        	  id: 'payment-form'
        	});       
        
     // braintree.onSubmitEncryptForm('payment-form');
    </script>
  </body>
</html>
