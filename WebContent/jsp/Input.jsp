<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="pascalBeans" class="dto.PascalBeans" scope="request" />
<jsp:useBean id="seatLinearSearchBeans" class="dto.SeatSearchBeans"
	scope="request" />
<jsp:useBean id="seatBinarySearchBeans" class="dto.SeatSearchBeans"
	scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>呼び出し元のJSP</title>
</head>
<body>

	<p>Q1.一発で決まる多数決</p>

	<form action="http://localhost:8080/Test/MajorityController"
		method="post">
		<input type="text" name="Number" value="" /> <input type="submit"
			value="計算" />
		<p>${Q1Error}</p>
		<p>${Q1Answer}</p>
	</form>

	<p>Q2.山手線でスタンプラリー</p>

	<form action="http://localhost:8080/Test/RallyController" method="post">
		駅の数<input type="text" name="StationNumber" value="" /> 出場する駅の番号<input
			type="text" name="selectNumber" value="" /> <input type="submit"
			value="計算" />
		<p>${Q2Error}</p>
		<p>${Q2Answer}</p>
	</form>

	<p>Q3.ローマ数字の変換規則</p>

	<form action="http://localhost:8080/Test/NumericalController"
		method="post">
		並べる数<input type="text" name="listNumber" value="" /> <input
			type="submit" value="計算" />

		<p>${Q3Error}</p>
		<p>${Q3Answer}</p>
	</form>

	<p>Q4.点灯している量で考えるデジタル時計</p>

	<form action="http://localhost:8080/Test/DisplayCountController"
		method="post">
		点灯個所の数<input type="text" name="selectNumber" value="" /> <input
			type="submit" value="計算" />
		<p>${Q4Error}</p>
		<p>${Q4Answer}</p>
	</form>

	<p>Q5.枚数で考えるパスカルの三角形</p>

	<form action="http://localhost:8080/Test/PascalCountController"
		method="post">
		パスカルの三角形の段数を入力してください<input type="text" name="stageNumber" value="" />
		<input type="submit" value="計算" />
	</form>
	<p>${pascalBeans.answer}</p>

	<p>Q10.アダムズ方式で議席数を計算せよ！</p>


	<form action="http://localhost:8080/Test/SeatLinearSearchController"
		method="post">
		<p>以下のフォームに全体の議席数を入力してください</p>
		<input type="text" name="SeatNumber" value="" /> <input type="submit"
			value="線形探索による計算" />
	</form>
	<p>${seatLinearSearchBeans.msg}</p>
	<%
		String[] linearSeat = seatLinearSearchBeans.getSeat();
		if (linearSeat != null) {
			for (int i = 0; i < linearSeat.length - 1; i++) {
				out.println(linearSeat[i]);
			}
		}
	%>

	<form action="http://localhost:8080/Test/SeatBinarySearchController"
		method="post">
		<input type="text" name="SeatNumber" value="" /> <input type="submit"
			value="二分探索による計算" />
	</form>

	<p>${seatBinarySearchBeans.msg}</p>

	<%
		String[] binarySeat = seatBinarySearchBeans.getSeat();
		if (binarySeat != null) {
			for (int i = 0; i < binarySeat.length - 1; i++) {
				out.println(binarySeat[i]);
			}
		}
	%>

</body>