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
 * Servlet implementation class SeatBinarySearchController
 */
@WebServlet("/SeatBinarySearchController")
public class SeatBinarySearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");

		//beansをインスタンス化してメッセージをセットする処理
		SeatSearchBeans seatBinarySearchBeans = new SeatSearchBeans();
		seatBinarySearchBeans.setMsg("1以上の数字を入力してください");
		String seatNum = request.getParameter("SeatNumber");
		//isNumberメソッドでtrueが返ってきた場合{}内の処理実行
		if (NumberUtils.isNumber(seatNum)) {
			seatBinarySearchBeans.setMsg("二分探索により計算した結果、各都道府県の議席数は以下の通りです");
			//処理用のクラスSeatSearchProcessをインスタンス化
			SeatSearchProcess seatSearchProcess = new SeatSearchProcess();
			//インスタンス化したseatSearchBeansと、入力値seatNumを引数として渡す
			seatSearchProcess.calcBinarySearch(seatBinarySearchBeans, (Integer.parseInt(seatNum)));
		}
		request.setAttribute("seatBinarySearchBeans", seatBinarySearchBeans);
		RequestDispatcher dispatch = request.getRequestDispatcher("jsp/Input.jsp");
		dispatch.forward(request, response);

	}

}
