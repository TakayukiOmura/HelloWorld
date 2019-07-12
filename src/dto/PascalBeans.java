package dto;

import java.io.Serializable;

public class PascalBeans implements Serializable {

	//フィールドをprivate修飾子でカプセル化
	private String answer = "";

	//引数の無いデフォルトコンストラクタ
	public PascalBeans() {

	}

	public PascalBeans(String msg) {
		this.answer = msg;
	}

	public PascalBeans(String pascalBeans, String msg) {

	}

	public String getAnswer() {
		return this.answer;
	}

}

