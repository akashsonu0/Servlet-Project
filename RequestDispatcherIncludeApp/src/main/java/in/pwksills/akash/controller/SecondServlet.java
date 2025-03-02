package in.pwksills.akash.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("\nSecondServlet.doGet()");
		System.out.println("Request Object info  :: "+request.hashCode() + ":: " +  request.getClass().getName());
		System.out.println("Response Object info :: "+response.hashCode());
		
		PrintWriter out = response.getWriter();
		out.println("<body bgcolor='cyan' align='center'>");
		out.println("<h1 style='color:green; text-align:center;'>Response from second servlet...</h1>");	
		out.println("<table border='1' align='center'>");
		
		out.println("<tr><th>ATTRIBUTENAME</th><th>ATTRIBUTEVALUE</th></tr>");
		Enumeration<String> attributeNames = request.getAttributeNames();
		
		while (attributeNames.hasMoreElements()) {
			out.println("<tr>");
			String attributeName = (String) attributeNames.nextElement();
			Object value = request.getAttribute(attributeName);
			out.println("<td>" + attributeName + "</td>");
			out.println("<td>" + value + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println(10/0);
	}
}
