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

	<form action="http://localhost:8080/Test/MajorityController" method="post">
		<input type="text" name="Number" value="" /> <input type="submit"
			value="送信" /><p>${Error}</p><p>${Answer}</p>
	</form>

	<p>Q2.山手線でスタンプラリー</p>

	<form action="http://localhost:8080/Test/StanpRallyController" method="post">
		<input type="text" name="Number" value="" /> <input type="submit"
			value="17で送信" /><p>${Error}</p><p>${Answer2}</p>
	</form>

</body>
</html>