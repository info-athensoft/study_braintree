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
<h3>Braintree Credit Card Transaction Form</h3>

<form id='braintree-payment-form' action='sccstorage_result.do' method='POST'>
	<h2>Customer Information</h2>
        <p>
          <label>First Name</label>
          <input type='text' name='first_name' id='first_name' value="Fz"></input>
        </p>
        <p>
          <label for='last_name'>Last Name</label>
          <input type='text' name='last_name' id='last_name' value="Sun"></input>
        </p>
        <p>
          <label for='postal_code'>Postal Code</label>
          <input type='text' name='postal_code' id='postal_code' value="H4V 1N8"></input>
        </p>
        <h2>Credit Card</h2>
        <p>
          <label>Card Number</label>
          <input type="text" size="20" autocomplete="off" data-encrypted-name="number" value="4111111111111111" />
        </p>
        <p>
          <label>CVV</label>
          <input type="text" size="4" autocomplete="off" data-encrypted-name="cvv" value="100" />
        </p>
        <p>
          <label>Expiration (MM/YYYY)</label>
          <input type="text" size="2" name="month" value="01" /> / <input type="text" size="4" data-encrypted-name="year" value="2020" />
        </p>
        <input class='submit-button' type='submit' />
    </form>
    
<br/>
<script type="text/javascript" src="https://js.braintreegateway.com/v1/braintree.js"></script>
<script type="text/javascript">

  var key = "MIIBCgKCAQEAwizigqXifK5hgQQLSexMe9IXuexOA7pjXWUrZ8AFHTzOzcJGKqX8GAQol9Ea7VEw+i/CUibD1aDUeP0KuvFY5s/KnuGBo4dzUy4lY4QAQNoihhGw7Sbm8KS5IchZSiP/t0HUTjCztq4P/pfaWp0fFwLuVGBGTRCY7UfhO8p85teX8LenlzITb7aruObpZDIQX3AXFUn+OFjclFEjZh6I17+MYjkOhRD0atcCh/DoF6oKcnZ/M1FrJU2V7Mgg3PzAToBqinOxdcGZn/E89P/ws8sHUKWd1cNkBTnGuLTLJQ+ZqQ+UatlEtxjLiyELO/dnt/yoSk2LVndGFnq7NVFuswIDAQAB";
  var braintree = Braintree.create(key);
  braintree.onSubmitEncryptForm('braintree-payment-form');
</script>

</body>
</html>