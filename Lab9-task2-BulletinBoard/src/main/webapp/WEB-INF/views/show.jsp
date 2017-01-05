<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Message result</title>
	<style type="text/css">
		div.message {
			margin: 4px;
			margin-left: 8px;
		}
	</style>
</head>
<body>
	<h1>Messages: </h1>
	
	<c:forEach items="${list}" var="message">
		<div class="message">
			<h3><c:out value="${message.subject}" /></h3>
			Message ID: <a href="/bulletinboard/msg?id=${message.id}"><c:out value="${message.id}" /></a> <br />
			Author: <a href="/bulletinboard/msg/${message.author}"><c:out value="${message.author}" /></a> <br />
			Message content: <c:out value="${message.body}" /> <br />
			<hr />
		</div>
	</c:forEach>

</body>
</html>