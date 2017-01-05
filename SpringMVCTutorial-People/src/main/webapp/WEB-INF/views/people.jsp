<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Show people</title>
	<style type="text/css">
		div.person {
			margin-left: 8px;
			margin-top: 4px;
		}
		
		#people-container {
			background-color: #cccccc;
			margin: 4px;
		}
	</style>
</head>
<body>
	
	<h1>Registered people</h1>
	<div id="people-container">
	
		<c:forEach items="${people}" var="p">
		
		<div class="person">
			<p class="name">Name: <c:out value="${p.name}" /></p>
			<p class="age">Age: <c:out value="${p.age}" /></p>
			<p class="gender">Gender: <c:out value="${p.gender}" /></p>
		</div>
		
		</c:forEach>
	
	</div>

</body>
</html>