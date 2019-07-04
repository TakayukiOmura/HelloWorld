package process;

public class RallyProcess {

	public int calcRally(int num1,int num2) {

		//Mathクラスのpowメソッドを使用してべき乗
		int inner = (int) Math.pow(2, num2 - 2);
		int outer = (int) Math.pow(2, num1 - num2);
		int answer = inner + outer - 1;

		return answer;
	}

	public String calcRally(String station_num, String select_num) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}