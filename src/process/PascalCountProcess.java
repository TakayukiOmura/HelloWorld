package process;

public class PascalCountProcess {
	//パスカルの三角形について入力した段数の各要素の値を求めるメソッド
	public long calcPascal(int selectNumber) {

		long[] pascalArray = new long[selectNumber + 1];

		pascalArray[0] = 1;

		for (int i = 0; i < selectNumber; i++) {

			for (int j = i + 1; j > 0; j--) {

				pascalArray[j] = pascalArray[j] + pascalArray[j - 1];

			}

		}
		return convertMoney(pascalArray);
	}

	//パスカルの三角形の値から最小の枚数を算出するメソッド
	public static long convertMoney(long[] pascalArray) {
		//お金の枚数をcountする変数moneyCountを宣言
		long moneyCount = 0;
		for (int i = 0; i < pascalArray.length; i++) {
			// ----------------------------------------------------
			// 10000円の枚数
			//pascalValueを紙幣・硬貨で割った商を変数紙幣・硬貨名に対応したDisit変数に代入
			long tenThousandDigits = pascalArray[i] / 10000;
			//pascalValueを紙幣や硬貨で割った余りをmoneyRemainderに代入
			long moneyRemainder = pascalArray[i] % 10000;
			moneyCount += tenThousandDigits;

			// ----------------------------------------------------
			// 5000円の枚数
			long fiveThousandDigits = moneyRemainder / 5000;
			moneyRemainder %= 5000;
			// 足しあげ
			moneyCount += fiveThousandDigits;

			// ------------------------------------------------------
			// 2000円の枚数
			long twoThousandDigits = moneyRemainder / 2000;
			moneyRemainder %= 2000;
			moneyCount += twoThousandDigits;


			long thousandDigits = moneyRemainder / 1000;
			moneyRemainder %= 1000;

			moneyCount += thousandDigits;

			long fiveHandledDigits = moneyRemainder / 500;
			moneyRemainder %= 500;

			moneyCount += fiveHandledDigits;

			long handledDigits = moneyRemainder / 100;
			moneyRemainder %= 100;

			moneyCount += handledDigits;

			long fiftyDigits = moneyRemainder / 50;
			moneyRemainder %= 50;

			moneyCount += fiftyDigits;

			long tenDigits = moneyRemainder / 10;
			moneyRemainder %= 10;

			moneyCount += tenDigits;

			long fiveDigits = moneyRemainder / 5;
			moneyRemainder %= 5;

			moneyCount += fiveDigits;

			long oneDigits = moneyRemainder / 1;

			moneyCount += oneDigits;

		}
		return moneyCount;

	}

}
