<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Add new message</title>
</head>
<body>

	<h1>Add new message</h1>
	
	<form method="POST" action="/bulletinboard/add">
	
		Author: <input type="text" name="author" /> <br />
		Subject: <input type="text" name="subject" /> <br />
		Body: <input type="text" name="body" /> <br />
		
		<input type="submit" />
	
	</form>

</body>
</html>