<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>    

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>user-acct-list.jsp</h3>
	
	<c:forEach items="${userAccountList}" var="userAccount">
		<c:out value="${userAccount.acctId}"></c:out>	&nbsp;&nbsp;
		<c:out value="${userAccount.acctName}"></c:out> &nbsp;&nbsp;
		<c:out value="${userAccount.password}"></c:out> &nbsp;&nbsp;
		<c:out value="${userAccount.primaryEmail}"></c:out> &nbsp;&nbsp;
		<c:out value="${userAccount.secureEmail}"></c:out>  &nbsp;&nbsp;
		<c:out value="${userAccount.createDate}"></c:out>  &nbsp;&nbsp;
		
		<fmt:formatDate type="both" 
            dateStyle="medium" timeStyle="medium" 
            value="${userAccount.createDate}" />
            		
		<c:out value="${userAccount.lastModDate}"></c:out>  &nbsp;&nbsp;
		<c:out value="${userAccount.acctStatus}"></c:out>  &nbsp;&nbsp;
		<br/>
	</c:forEach>
</body>
</html>