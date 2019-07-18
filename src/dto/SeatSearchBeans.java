package dto;

import java.io.Serializable;

//値を保持するbeansクラス
public class SeatSearchBeans implements Serializable {

	//フィールドをprivate修飾子でカプセル化
	private String msg;
	private String[] seat;


	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String[] getSeat() {
		return seat;
	}
	public void setSeat(String[] seat) {
		this.seat = seat;
	}



}
