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
 * Servlet implementation class SUNMSServlet
 */
@WebServlet("/sun")
public class SUNMSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SUNMSServlet.doGet()");

		ServletContext context = getServletContext();
		ServletContext fc = context.getContext("/OracleApp");
		System.out.println(fc.getClass().getName());
		RequestDispatcher rd = fc.getRequestDispatcher("/oracle");
		rd.forward(request, response);

	}

}
