package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.SeatSearchBeans;
import process.SeatSearchProcess;
import util.NumberUtils;

/**
 * Servlet implementation class SeatLinearSearchController
 */
@WebServlet("/SeatLinearSearchController")
public class SeatLinearSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");

		//beansをインスタンス化してメッセージをセットする処理
		SeatSearchBeans seatLinerSearchBeans = new SeatSearchBeans();
		seatLinerSearchBeans.setMsg("1以上の数字を入力してください");
		String seatNum = request.getParameter("SeatNumber");
		//isNumberメソッドでtrueが返ってきた場合{}内の処理実行
		if (NumberUtils.isNumber(seatNum)) {
			seatLinerSearchBeans.setMsg("線形探索により計算した結果、各都道府県の議席数は以下の通りです");
			//処理用のクラスSeatSearchProcessをインスタンス化
			SeatSearchProcess seatSearchProcess = new SeatSearchProcess();
			//インスタンス化したseatSearchBeansと、入力値seatNumを引数として渡す
			seatSearchProcess.calcLinearSearch(seatLinerSearchBeans, (Integer.parseInt(seatNum)));
		}
		request.setAttribute("seatLinearSearchBeans", seatLinerSearchBeans);
		RequestDispatcher dispatch = request.getRequestDispatcher("jsp/Input.jsp");
		dispatch.forward(request, response);

	}

}
