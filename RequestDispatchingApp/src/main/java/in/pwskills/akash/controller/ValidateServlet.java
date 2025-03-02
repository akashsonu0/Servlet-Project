package in.pwskills.akash.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidateServlet
 */
@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// getting the parameter data from request object
		String username = request.getParameter("username");
		String userpassword = request.getParameter("userpassword");

		ServletContext context = getServletContext();
		RequestDispatcher rd = null;
		if (username.equalsIgnoreCase("sachin") && userpassword.equals("tendulkar")) {
			// success page
			rd = context.getRequestDispatcher("/inbox.jsp");
			rd.forward(request, response);

		} else {
			// failure page
			rd = context.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
	}
}
