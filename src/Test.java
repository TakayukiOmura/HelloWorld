import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Input.jspからデータを受け取る
		request.setCharacterEncoding("UTF8");
		String jsp = request.getParameter("Jsp");

		// Result.Jspに渡すデータをセット
		request.setAttribute("Servlet", jsp + "World");

		// result.jsp にページ遷移
		RequestDispatcher dispatch = request.getRequestDispatcher("jsp/Result.jsp");
		dispatch.forward(request, response);
	}
}
