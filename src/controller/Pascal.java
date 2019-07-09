package controller;

public class Pascal {

	public static void main(String[] args) {
int count=0;
		//初項を設定
        int selectNumber = 45;
		int[] secondArray = new int[selectNumber];
		secondArray[0] = 1;
		for (int i = 0; i <= selectNumber; i++) {
			//int[] firstArray = new int[1];
			//firstArray[0] = 1;
			for (int j = i + 1; j > 0; j--) {

				secondArray[j] = secondArray[j] + secondArray[j - 1];
if(i==selectNumber) {
	 count += countMoney(secondArray[j]);

}

				System.out.print(secondArray[j] + " ");

			}
			System.out.println();
		}
		System.out.println(count);
	}

	//パスカルの三角形の値から最小の枚数絵を算出するメソッド
	public static int countMoney(int selectNumber) {

		//for (int number = 0; number <= 45; number++) {
		selectNumber = 52000;
		int moneyCount = 0;

		int tenThousandDigits = selectNumber / 10000;
		int remainder = selectNumber % 10000;
		if (tenThousandDigits > 0) {
			moneyCount += tenThousandDigits;
		}

		int fiveThousandDigits = remainder / 5000;
		remainder %= 5000;
		if (fiveThousandDigits > 0) {
			moneyCount += fiveThousandDigits;
		}

		int twoThousandDigits = remainder / 1000;
		remainder %= 1000;
		if (twoThousandDigits > 0) {
			moneyCount += twoThousandDigits;
		}

		int thousandDigits = remainder / 1000;
		remainder %= 1000;
		if (thousandDigits > 0) {
			moneyCount += thousandDigits;
		}

		int fiveHandledDigits = remainder / 500;
		remainder %= 500;
		if (fiveHandledDigits > 0) {
			moneyCount += fiveHandledDigits;
		}

		int handledDigits = remainder / 100;
		remainder %= 100;
		if (handledDigits > 0) {
			moneyCount += handledDigits;
		}

		int fiftyDigits = remainder / 50;
		remainder %= 50;
		if (fiftyDigits > 0) {
			moneyCount += fiftyDigits;
		}

		int tenDigits = remainder / 10;
		remainder %= 10;
		if (tenDigits > 0) {
			moneyCount += tenDigits;
		}

		int fiveDigits = remainder / 5;
		remainder %= 5;
		if (fiveDigits > 0) {
			moneyCount += fiveDigits;
		}

		int oneDigits = remainder / 1;

		if (oneDigits > 0) {
			moneyCount += oneDigits;
		}
		System.out.println(moneyCount);
		return moneyCount;

	}
}
