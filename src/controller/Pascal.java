package controller;

public class Pascal {

	public static void main(String[] args) {
		//int count = 0;

		int selectNumber = 45;
		selectNumber += 2;

		long[] pascalArray = new long[selectNumber];

		pascalArray[0] = 1;
		long money = 0;
		for (int i = 0; i <= selectNumber; i++) {

			for (int j = i + 1; j > 0; j--) {

				pascalArray[j] = pascalArray[j] + pascalArray[j - 1];
				if (i == 45) {

					money += convertMoney(pascalArray[j - 1]);
				}

				//System.out.print((pascalArray[j - 1]) + " ");
				//				for( j=0 ;j<pascalArray.length;j++) {
				//
				//				}
			}

			System.out.println();
			System.out.println(money);
		}

		//System.out.println(count);
	}

	//パスカルの三角形の値から最小の枚数を算出するメソッド
	public static int convertMoney(long pascalValue) {

		//お金の枚数をcountする変数moneyCountを宣言
		int moneyCount = 0;
		//pascalValueを紙幣・硬貨で割った商を変数紙幣・硬貨名に対応したDisit変数に代入
		long tenThousandDigits = pascalValue / 10000;
		//pascalValueを紙幣や硬貨で割った余りをmoneyRemainderに代入
		long moneyRemainder = pascalValue % 10000;

		if (tenThousandDigits > 0) {
			moneyCount += tenThousandDigits;
		}

		long fiveThousandDigits = moneyRemainder / 5000;
		moneyRemainder %= 5000;
		if (fiveThousandDigits > 0) {
			moneyCount += fiveThousandDigits;
		}

		long twoThousandDigits = moneyRemainder / 2000;
		moneyRemainder %= 2000;
		if (twoThousandDigits > 0) {
			moneyCount += twoThousandDigits;
		}

		long thousandDigits = moneyRemainder / 1000;
		moneyRemainder %= 1000;
		if (thousandDigits > 0) {
			moneyCount += thousandDigits;
		}

		long fiveHandledDigits = moneyRemainder / 500;
		moneyRemainder %= 500;
		if (fiveHandledDigits > 0) {
			moneyCount += fiveHandledDigits;
		}

		long handledDigits = moneyRemainder / 100;
		moneyRemainder %= 100;
		if (handledDigits > 0) {
			moneyCount += handledDigits;
		}

		long fiftyDigits = moneyRemainder / 50;
		moneyRemainder %= 50;
		if (fiftyDigits > 0) {
			moneyCount += fiftyDigits;
		}

		long tenDigits = moneyRemainder / 10;
		moneyRemainder %= 10;
		if (tenDigits > 0) {
			moneyCount += tenDigits;
		}

		long fiveDigits = moneyRemainder / 5;
		moneyRemainder %= 5;
		if (fiveDigits > 0) {
			moneyCount += fiveDigits;
		}

		long oneDigits = moneyRemainder / 1;

		if (oneDigits > 0) {
			moneyCount += oneDigits;
		}

		return moneyCount;

	}
}
