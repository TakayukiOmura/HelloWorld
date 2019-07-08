package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import process.MajorityProcess;
import util.NumberUtils;

@WebServlet("/MajorityController")
public class MajorityController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");

		//serviceパッケージのCalcMajorityクラスをインスタンス化
		MajorityProcess majorityProcess = new MajorityProcess();

		//	オブジェクト型のNumberをString型に変換
		String num = (String) (request.getParameter("Number"));

		String paramName = "Q1Error";

		String msg = "１以上の数字を入力してください";

		//isNumberメソッドでtrueが返ってきた場合{}内の処理を実行
		if (NumberUtils.isNumber(num)) {

			paramName = "Q1Answer";
			msg = "A:" + majorityProcess.calcMajority(Integer.parseInt(num)) + "通り";

		}
		request.setAttribute(paramName, msg);
		//Input.jsp にページ遷移
		RequestDispatcher dispatch = request.getRequestDispatcher("jsp/Input.jsp");
		dispatch.forward(request, response);

	}
}