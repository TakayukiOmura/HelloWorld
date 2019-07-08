package process;

public class NumericalProcess {

	//
	int count = 0;

	public int calcNumerical(int listNum) {

		// 変数宣言桁ごとに割り算
		//int thousandDigits;
		// int handledDigits;
		//int tenDigits;
		//int remainder;
		//文字列格納用
		String resultStr = "";

		for (int number = 0; number <= 3999; number++) {
			int thousandDigits = number / 1000;
			int remainder = number % 1000;

			// 4桁目が1以上の場合=1000以上の数の場合
			if (thousandDigits > 0) {
				// 4桁目をローマ数字に変換する
				resultStr = changeNum(thousandDigits, resultStr, "", "", "M");

			}
			// 100で割る
			int handledDigits = remainder / 100;
			remainder %= 100;

			//3桁目が1以上の場合=100以上の数の場合
			if (handledDigits > 0) {
				//3桁目をローマ字に変換する
				resultStr = changeNum(handledDigits, resultStr, "M", "D", "C");
			}
			// 10で割る
			int tenDigits = remainder / 10;
			remainder %= 10;
			//2行目が1以上の時
			if (tenDigits > 0) {
				resultStr = changeNum(tenDigits, resultStr, "C", "L", "X");
			}
			if(remainder != 0) {
			resultStr = changeNum(remainder, resultStr, "X", "V", "I");
			}
			if (resultStr.length() == listNum) {
				count++;
				System.out.println(resultStr);
			}
			resultStr = "";

		}
		return count;
	}

	// b=1000,c=500,d=100
	public static String changeNum(int remainder, String resultString, String b, String c, String d) {

		// 9だった場合の処理
		if (remainder == 9) {
			resultString += d + b;
		}
		// 8だった場合の処理
		if (remainder == 8) {
			resultString += c + d + d + d;
		}
		// 7だった場合の処理
		if (remainder == 7) {
			resultString += c + d + d;
		}
		// 6だった場合の処理
		if (remainder == 6) {
			resultString += c + d;
		}
		// 5だった場合の処理
		if (remainder == 5) {
			resultString += c;
		}
		// 4だった場合の処理
		if (remainder == 4) {
			resultString += d + c;
		}
		// 3だった場合の処理
		if (remainder == 3) {
			resultString += d + d + d;
		}
		// 2だった場合の処理
		if (remainder == 2) {
			resultString += d + d;
		}
		// 1だった場合の処理
		if (remainder == 1) {
			resultString += d;
		}
		//int answer = resultString.length();
		return resultString;
	}

}