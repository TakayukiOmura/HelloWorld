package process;

import java.util.ArrayList;

public class DisplayCountProcess {

	//何通り有るかを返すメソッド
	public int calcCount(int selectNum) {

		return calcTime(selectNum);

		//return count;
	}

	//時刻を算出するメソッド
	private int calcTime(int selectNum) {
		//取得したディスプレイの数を詰める可変長配列resultArrayを設定
		ArrayList<Integer> resultArray = new ArrayList<>();
		int count = 0;
		for (int hour = 0; hour < 24; hour++) {

			for (int minutes = 0; minutes < 60; minutes++) {

				for (int seconds = 0; seconds < 60; seconds++) {
					//3重for文で時間、分、秒を算出し、時刻を取得する。
					int displayNumber = calcDisplay(hour, minutes, seconds);

					resultArray.add(displayNumber);
				}

			}

		}
		for (int i = 0; i < resultArray.size(); i++) {
			//resultArrayに詰めたdisplayNumberの値が一緒であればcount++する。
			if (resultArray.get(i) == selectNum) {

				count++;
			}
		}
		return count;

	}

	//時刻から点灯しているディスプレイを算出するメソッド。
	private int calcDisplay(int hour, int minutes, int seconds) {

		//配列の添え字を数字に見立て、対応するディスプレイの点灯個所数を設定する。
		int array[] = { 6, 2, 5, 5, 4, 5, 6, 3, 7, 6 };

		//時間の10の位
		int hourTen = hour / 10;
		//時間の1の位
		int hourOne = hour % 10;

		int hourDisplay = array[hourTen] + array[hourOne];
		//分の10の位
		int minutesTen = minutes / 10;
		//分の1の位
		int minutesOne = minutes % 10;

		int minutesDisplay = array[minutesTen] + array[minutesOne];
		//秒の10の位
		int secondsTen = seconds / 10;
		//秒の1の位
		int secondsOne = seconds % 10;

		int secondsDisplay = array[secondsTen] + array[secondsOne];
		//ディスプレイの合計
		int displayNumber = hourDisplay + minutesDisplay + secondsDisplay;

		return displayNumber;
	}
}
