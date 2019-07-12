package process;

public class PascalProcess {

	private int countMoney(int selectNumber) {

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
