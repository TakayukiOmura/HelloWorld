

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessinGetServlet
 */
@WebServlet("/SessinGetServlet")
public class SessinGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SessinGetServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(false);

		//session.setAttribute("name1","abc");
		//session.setAttribute("name2",1);

		if(session != null) {
			String name1 = (String)session.getAttribute("name1");
			Integer name2 = (Integer)session.getAttribute("name2");
			System.out.println("name1 =" + name1);
			System.out.println("name2 =" + name2);
			/*RequestDispatcher dispatcher =
			request.getRequestDispatcher("jsp/session.jsp");
	dispatcher.forward(request,response);
	return;*/


		}


	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
