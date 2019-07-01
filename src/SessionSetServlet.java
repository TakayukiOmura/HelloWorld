

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionSetServlet
 */
@WebServlet("/SessionSetServlet")
public class SessionSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SessionSetServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//セッション
		HttpSession session = request.getSession(true);
		/*if(session != null) {
			String name1 = (String)session.getAttribute("name1");
			Integer name2 = (Integer)session.getAttribute("name2");

			System.out.println("name1 =" + name1);
			System.out.println("name2 =" + name2);
		}*/

		session.setAttribute("name1","abc");
		session.setAttribute("name2",1);

		RequestDispatcher dispatcher =
				request.getRequestDispatcher("jsp/session.jsp");
		dispatcher.forward(request,response);
		return;

	}
	//HttpSession session = request.getSession(false);


	//response.getWriter().append("Served at: ").append(request.getContextPath());


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
