package in.pwksills.akash.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet.doGet()");
		System.out.println("Request Object info  :: " + request.hashCode() + " " + request.getClass().getName());
		System.out.println("Response Object info :: " + response.hashCode());

		PrintWriter out = response.getWriter();
		out.println("<h1 style='color:red; text-align:center;'>Response from first servlet...</h1>");

		// Setting the attributes
		request.setAttribute("COMPANY", "PWSKILLS");
		request.setAttribute("TYPE", "EDTECH");
		request.setAttribute("LOCATION", "NOIDA");

		RequestDispatcher rd = request.getRequestDispatcher("./second");
		rd.include(request, response);

		out.println("<h1 style='color:red;  text-align:center;'>Again the response from first servlet...</h1>");
		out.close();
	}
}


