<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>People age checker</title>
</head>
<body>

	<h1>Age checker</h1>
	<div>
	<c:choose>
		<c:when test="${person.age < 0}">
			<span>No such person exists!!</span>
		</c:when>
	    <c:when test="${person.age < 20}">
	        <c:out value="${person.name}"/> is a teenager!    
	    </c:when>    
	    <c:when test="${person.age >= 20 && person.age < 30}">
	        <c:out value="${person.name}"/> is at the best age!    
	    </c:when>
	    <c:when test="${person.age >= 30 && person.age < 40}">
	        <c:out value="${person.name}"/> is getting old.   
	    </c:when>
	    <c:otherwise>
	        <c:out value="${person.name}"/> should retire from job! 
	    </c:otherwise> 
	</c:choose>
	</div>
</body>
</html>