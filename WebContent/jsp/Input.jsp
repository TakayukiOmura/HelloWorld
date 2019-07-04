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
			value="計算" /><p>${Q1Error}</p><p>${Q1Answer}</p>
	</form>

	<p>Q2.山手線でスタンプラリー</p>

	<form action="http://localhost:8080/Test/RallyController" method="post">
		<input type="text" name="StationsNumber" value="" />
		<<input type="text" name="Number" value="" />
		<input type="submit"
			value="計算" /><p>${Q2Error}</p><p>${Q2Answer}</p>
	</form>

</body>
</html>