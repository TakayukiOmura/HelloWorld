package process;

public class MajorityProcess {

	public int calcMajority(int num) {
		int count = 0;
		for (int goo = 0; goo <= num; goo++) {

			for (int tyoki = 0; tyoki <= num - goo; tyoki++) {

				int paa = num - goo - tyoki;
				if (isMajority(goo, tyoki, paa)) {
					count++;
				}
			}
		}
		//メソッド呼び出し元に計算結果を返す。
		return count++;
	}

	private boolean isMajority(int goo, int tyoki, int paa) {

		//グーとチョキとパーが同数の場合
		if (goo == tyoki && tyoki == paa) {
			return false;
		}
		//グーとチョキが同数かつパーよりも大きい場合
		if (goo == tyoki && goo > paa) {
			return false;
		}
		//チョキとパーが同数かつグーよりも大きい場合
		if (tyoki == paa && tyoki > goo) {
			return false;
		}
		//パーとグーが同数かつチョキよりも大きい場合
		if (paa == goo && paa > tyoki) {
			return false;
		}
		// 上記以外は多数決で決定
		return true;

	}
}