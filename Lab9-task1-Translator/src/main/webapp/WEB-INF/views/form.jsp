<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Pig latin translator</title>
</head>
<body>
	<h1>Submit a word to be translated</h1>
	
	<form method="POST" action="/translate/piglatinmvc/form">
	
		Word: <input type="text" name="word"/>
		
		<input type="submit" value="translate" /> 
	
	</form>

</body>
</html>