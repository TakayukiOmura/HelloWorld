package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.PascalBeans;
import process.PascalCountProcess;
import util.NumberUtils;

@WebServlet("/PascalCountController")
public class PascalCountController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");

		//Jspで入力した値を受け取る
		String stageNumber = request.getParameter("stageNumber");

		String msg = "１以上の数字を入力してください";

		//isNumberメソッドでtrueが返ってきた場合{}内の処理実行
		if (NumberUtils.isNumber(stageNumber)) {

			PascalCountProcess pascalCountProcess = new PascalCountProcess();
			msg = ("A:"+stageNumber +"段目のパスカルの三角形のそれぞれの値を紙幣・硬貨での最小の枚数に換算した和" + pascalCountProcess.calcPascal(Integer.parseInt(stageNumber)) + "枚");
		}

		PascalBeans pascalBeans = new PascalBeans(msg);

		request.setAttribute("pascalBeans", pascalBeans);

		//Jspにページ遷移する。
		RequestDispatcher dispatch = request.getRequestDispatcher("jsp/Input.jsp");
		dispatch.forward(request, response);
	}

}

