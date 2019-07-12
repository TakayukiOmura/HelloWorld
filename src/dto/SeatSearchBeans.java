package dto;

import java.io.Serializable;

public class SeatSearchBeans implements Serializable {

	//フィールドをprivate修飾子でカプセル化
	private String answer = "";

	private String[] Seat = new String[46];

	//	public String getSelect(int id) {
	//	    return Seat[id];
	//}
	public String[] getSelect() {
		return Seat;
	}

	public void setSelect(String[] select) {
		this.Seat = select;
	}

	//引数の無いデフォルトコンストラクタ
	public SeatSearchBeans() {

	}

	public SeatSearchBeans(String msg) {
		this.answer = msg;
	}

	public SeatSearchBeans(String pascalBeans, String msg) {

	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
