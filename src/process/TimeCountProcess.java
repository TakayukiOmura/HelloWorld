package process;

public class TimeCountProcess {
	private int displayCount;

	//配列の添え字を数字に見立て、対応するディスプレイの点灯個所数を設定する。
	int array[] = { 6, 2, 5, 5, 4, 5, 6, 3, 7, 6 };
	int count = 0;
	public int calcTime(int selectNum) {

		for (int hour = 0; hour < 24; hour++) {

			for (int minutes = 0; minutes < 60; minutes++) {

				for (int seconds = 0; seconds < 60; seconds++) {

					displayCount = calcDisplay(hour, minutes, seconds);
					if (displayCount == selectNum) {
						count++;

					}

				}

			}

		}

		return count;
	}



	//時刻から点灯しているディスプレイを算出する。
	private int calcDisplay(int hour, int minutes, int seconds) {

		int hourTen = hour / 10;
		int hourOne = hour % 10;
		int hourDisplay = array[hourTen] + array[hourOne];
		int minutesTen = minutes / 10;
		int minutesOne = minutes % 10;
		int minutesDisplay = array[minutesTen] + array[minutesOne];
		int secondsTen = seconds / 10;
		int secondsOne = seconds % 10;
		int secondsDisplay = array[secondsTen] + array[secondsOne];
		int displayNumber = hourDisplay + minutesDisplay + secondsDisplay;

		return displayNumber;
	}
}
