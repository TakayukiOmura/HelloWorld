package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import process.DisplayCountProcess;
import util.NumberUtils;

//アノテーションJSPからServletをURLで呼び出す場合に末尾に付ける。
@WebServlet("/DisplayCountController")
public class DisplayCountController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");

		//オブジェクト型のNumberをString型に変換する
		String selectNum = (String) request.getParameter("selectNumber");

		String paramName = "Q4Error";

		String msg = "１以上の数字を入力してください";

		//isNumberメソッドでtrueが返ってきた場合{}内の処理実行
		if (NumberUtils.isNumber(selectNum)) {

			paramName = "Q4Answer";

			DisplayCountProcess displayCountProcess = new DisplayCountProcess();
			msg = ("A:" + displayCountProcess.calcCount(Integer.parseInt(selectNum)) + "通り");
		}
		request.setAttribute(paramName, msg);

		//Input.jsp にページ遷移
		RequestDispatcher dispatch = request.getRequestDispatcher("jsp/Input.jsp");
		dispatch.forward(request, response);
	}

}