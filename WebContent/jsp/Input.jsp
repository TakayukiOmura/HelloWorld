<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>呼び出し元のJSP</title>
</head>
<body>
	<!-- 遷移先のサーブレットへのパス指定 -->
	<form action="http://localhost:8080/Test/Test" method="post">
		<input type="hidden" name="Jsp"value="Hello"/> <input type="submit"
			value="実行" />
	</form>
</body>
</html>