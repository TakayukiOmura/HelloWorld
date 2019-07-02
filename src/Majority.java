
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Majority
 */
@WebServlet("/Majority")
public class Majority extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF8");
		//Input.Jspで入力した値をint型へ変換
		String num = (String)(request.getParameter("Number"));

		//何も入力されていない場合
		if ("".equals(num)) {

			request.setAttribute("Error", "１以上の数字を入力してください");

			RequestDispatcher dispatch = request.getRequestDispatcher("jsp/Input.jsp");
			dispatch.forward(request, response);

		} else {

			int answer = MajorityCalc(Integer.parseInt(num));

			// Input.Jspに渡すデータをセット
			request.setAttribute("Answer", "A:"+ answer + "通り");

			// result.jsp にページ遷移
			RequestDispatcher dispatch = request.getRequestDispatcher("jsp/Input.jsp");
			dispatch.forward(request, response);
		}
	}

	public int MajorityCalc(int num) {

		int count = 0;

		for (int goo = 0; goo <= num; goo++) {

			for (int tyoki = 0; tyoki <= num - goo; tyoki++) {

				int paa = num - goo - tyoki;
				//グーとチョキとパーが同数の場合
				if (goo == tyoki && tyoki == paa) {
					//グーとチョキが同数かつパーよりも大きい場合
				} else if (goo == tyoki && goo > paa) {
					//チョキとパーが同数かつグーよりも大きい場合
				} else if (tyoki == paa && tyoki > goo) {
					//パーとグーが同数かつチョキよりも大きい場合
				} else if (paa == goo && paa > tyoki) {

				} else {

					count++;

				}

			}

		}
		//メソッド呼び出し元に計算結果を返す。
		return count;
	}

}
