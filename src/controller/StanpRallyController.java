package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StanpRallyController")
public class StanpRallyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String num = (String) (request.getParameter("Number"));

		int InnerTracks = 1;
		int OuterTracks = 1;
		//if (NumberUtils.isNumber(num)) {

		int inputnum = (Integer.parseInt(num));
		int inter = (int) Math.pow(2, inputnum - 2);
		int outer = (int) Math.pow(2, 27 - inputnum);
		System.out.println(inter + outer - 1);

		for (int i = 0; i < inputnum - 2; i++) {

			InnerTracks *= 2;

		}
		for (int i = 0; i < 29 - inputnum; i++) {

			OuterTracks *= 2;

		}

		int answer = InnerTracks + OuterTracks - 1;
		//msg = "A:" + calcmajority.calcMajority(Integer.parseInt(num)) + "通り";

		//}

		request.setAttribute("Answer2", "A:" + answer + "通り");
		//Input.jsp にページ遷移
		RequestDispatcher dispatch = request.getRequestDispatcher("jsp/Input.jsp");
		dispatch.forward(request, response);

	}

}
