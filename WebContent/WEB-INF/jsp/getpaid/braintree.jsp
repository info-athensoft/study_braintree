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
      <form action="create_transaction.do" method="POST" id="braintree-payment-form">
        <p>
          <label>Card Number</label>
          <input type="text" size="20" autocomplete="off" data-encrypted-name="number" value="4111111111111111"/>
        </p>
        <p>
          <label>CVV</label>
          <input type="text" size="4" autocomplete="off" data-encrypted-name="cvv" />
        </p>
        <p>
          <label>Expiration (MM/YYYY)</label>
          <input type="text" size="2" data-encrypted-name="month" value="01"/> / <input type="text" size="4" data-encrypted-name="year" value="2020"/>
        </p>
        <input type="submit" id="submit" />
      </form>
    </div>
    <script type="text/javascript" src="https://js.braintreegateway.com/v1/braintree.js"></script>
    <script type="text/javascript">
    	var clientToken = "<c:out value='${clientToken}'/>";
        var braintree = Braintree.create(clientToken);
        
        braintree.setup(clientToken, 'custom', {
        	  id: 'braintree-payment-form'
        	});
        
        
      braintree.onSubmitEncryptForm('braintree-payment-form');
    </script>
  </body>
</html>
