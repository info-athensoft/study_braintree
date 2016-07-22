<%@ page contentType="text/html; charset=utf-8" %>
<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Braintree example - braintreeUrl</h3>

<form id='payment-form' action='${braintreeUrl}' method='POST'>
      <input type='hidden' name='tr_data' value='${trData}' />
      <div>
        <h2>Credit Card</h2>
        <label for='braintree_credit_card_number'>Credit Card Number</label>
        <input type='text' name='transaction[credit_card][number]' id='braintree_credit_card_number' value='4111111111111111'></input>
        <label for='braintree_credit_card_exp'>Credit Card Expiry (mm/yyyy)</label>
        <input type='text' name='transaction[credit_card][expiration_date]' id='braintree_credit_card_exp' value='12/2015'></input>
      </div>
      <input class='submit-button' type='submit' />
    </form>
    
<br/>

Result:${resultMessage}

</body>
</html>