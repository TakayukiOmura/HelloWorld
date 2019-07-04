package util;

public class NumberUtils{
	public static boolean isNumber(String str) {

		//入力値がnullだった場合falseを返す
		if ("".equals(str) || str == null){
			return false;
		}

		try {
			//strをint型に変換する事で数字以外が入力された時にキャッチする。
			Integer.parseInt(str);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
}
