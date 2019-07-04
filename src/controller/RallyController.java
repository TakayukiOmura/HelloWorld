package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import process.RallyProcess;
import util.NumberUtils;

//JSPからServletをURLで呼び出す場合に末尾に付ける。
@WebServlet("/RallyController")
public class RallyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");

		//オブジェクト型のNumberをString型に変換する
		String num = (String) (request.getParameter("Number"));

		String paramName = "Q2Error";

		String msg = "１以上の数字を入力してください";

		//isNumberメソッドでtrueが返ってきた場合{}内の処理実行
		if (NumberUtils.isNumber(num)) {

			RallyProcess rallyProcess = new RallyProcess();
			paramName = "Q2Answer";
			msg = "A:" + rallyProcess.calcRally(Integer.parseInt(num)) + "通り";

		}

		request.setAttribute(paramName, msg);
		//Input.jsp にページ遷移
		RequestDispatcher dispatch = request.getRequestDispatcher("jsp/Input.jsp");
		dispatch.forward(request, response);

	}
}
