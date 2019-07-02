<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>呼び出し元のJSP</title>
</head>
<body>

	<p>Q1.一発で決まる多数決</p>

	<form action="http://localhost:8080/Test/Majority" method="post">
		<input type="text" name="Number" value="" /> <input type="submit"
			value="送信" /><p>${Error}</p><p>${Answer}</p>
	</form>




</body>
</html>