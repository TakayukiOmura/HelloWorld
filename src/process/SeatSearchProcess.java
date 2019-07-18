package process;

import java.util.LinkedHashMap;
import java.util.Map;

import dto.SeatSearchBeans;

//全体の議席数から線形探索と二部探索を用いて各県の議席数を計算し、beansにその答えを詰めるクラス
public class SeatSearchProcess {

	//オブジェクト型の引数seatSearchBeansをSeatLinearSearchControllerから取得
	public void calcLinearSearch(SeatSearchBeans seatSearchBeans, int seatNum) {

		seatSearchBeans = new SeatSearchBeans();
		seatSearchBeans.setMsg("UNKO");

		Map<String, Integer> prefectureMap = createMap();

		//1から最大人口の数値までで割る
		for (double i = 1; i < 13515271; i++) {
			int count = 0;
			for (String key : prefectureMap.keySet()) {
				count += Math.ceil((prefectureMap.get(key) / i));
			}
			if (count == seatNum) {
				String[] linearArray = new String[47];
				int j = 0;
				for (String key : prefectureMap.keySet()) {
					linearArray[j] = (key + ":" + (int) Math.ceil((prefectureMap.get(key) / i)) + "席");
					j++;
				}
				seatSearchBeans.setSeat(linearArray);
				return;
			}
		}
	}

	//オブジェクト型の引数seatSearchBeansをSeatBinarySearchControllerから取得
	public void calcBinarySearch(SeatSearchBeans seatSearchBeans, int seatNum) {

		//seatSearchBeans = new SeatSearchBeans();
		seatSearchBeans.setMsg("UNKO"
				+ ""
				+ "");

		LinkedHashMap<String, Integer> prefectureMap = createMap();

		double left = 1;
		//人口の最大値を表す変数right
		double right = 13515271;
		//中間値を表す変数mid
		double mid = (left + right) / 2;

		while (left != right) {
			int count = 0;
			mid = (left + right) / 2;
			for (String key : prefectureMap.keySet()) {
				count += (int) Math.ceil((prefectureMap.get(key) / mid));
			}
		if (count == seatNum) {
				String[] binaryArray = new String[47];
				int j = 0;
				for (String key : prefectureMap.keySet()) {
					binaryArray[j] = (key + ":" + (int) Math.ceil((prefectureMap.get(key) / mid)) + "席");
					j++;
				}
				seatSearchBeans.setSeat(binaryArray);
				return;
			} else if (seatNum > count) {
				right = mid;
			} else {
				left = mid;
			}
				}
	}

	private LinkedHashMap<String, Integer> createMap() {

		// Mapの宣言
		LinkedHashMap<String, Integer> prefecture = new LinkedHashMap<>();

		prefecture.put("北海道", 5381733);
		prefecture.put("青森県", 1308265);
		prefecture.put("岩手県", 1279594);
		prefecture.put("宮城県", 2333899);
		prefecture.put("秋田県", 1023119);
		prefecture.put("山形県", 1123891);
		prefecture.put("福島県", 1914039);
		prefecture.put("茨城県", 2916976);
		prefecture.put("栃木県", 1974255);
		prefecture.put("群馬県", 1973115);
		prefecture.put("埼玉県", 7266534);
		prefecture.put("千葉県", 6222666);
		prefecture.put("東京都", 13515271);
		prefecture.put("神奈川県", 9126214);
		prefecture.put("新潟県", 2304264);
		prefecture.put("富山県", 1066328);
		prefecture.put("石川県", 1154008);
		prefecture.put("福井県", 786740);
		prefecture.put("山梨県", 834930);
		prefecture.put("長野県", 2098804);
		prefecture.put("岐阜県", 2031903);
		prefecture.put("静岡県", 3700305);
		prefecture.put("愛知県", 7483128);
		prefecture.put("三重県", 1815865);
		prefecture.put("滋賀県", 1412916);
		prefecture.put("京都府", 2610353);
		prefecture.put("大阪府", 8839469);
		prefecture.put("兵庫県", 5534800);
		prefecture.put("奈良県", 1364316);
		prefecture.put("和歌山県", 963579);
		prefecture.put("鳥取県", 573441);
		prefecture.put("島根県", 694352);
		prefecture.put("岡山県", 1921525);
		prefecture.put("広島県", 2843990);
		prefecture.put("山口県", 1404729);
		prefecture.put("徳島県", 755733);
		prefecture.put("香川県", 976263);
		prefecture.put("愛媛県", 1385262);
		prefecture.put("高知県", 728276);
		prefecture.put("福岡県", 5101556);
		prefecture.put("佐賀県", 832832);
		prefecture.put("長崎県", 1377187);
		prefecture.put("熊本県", 1786170);
		prefecture.put("大分県", 1166338);
		prefecture.put("宮崎県", 1104069);
		prefecture.put("鹿児島県", 1648177);
		prefecture.put("沖縄県", 1433566);

		return prefecture;
	}

}
