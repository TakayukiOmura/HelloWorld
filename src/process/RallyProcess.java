package process;

public class RallyProcess {

	public int calcRally(int num) {

		//Mathクラスのpowメソッドを使用してべき乗
		 int inner = (int) Math.pow(2, num - 2);
		int  outer =  (int)Math.pow(2, 29 - num);
		int answer = inner + outer - 1;

		return answer;
	}
}