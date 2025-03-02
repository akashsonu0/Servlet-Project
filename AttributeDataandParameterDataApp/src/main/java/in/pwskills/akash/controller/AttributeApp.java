package in.pwskills.akash.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AttributeApp
 */
@WebServlet("/attribute")
public class AttributeApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		ServletContext context = getServletContext();

		context.setAttribute("NAME", "PWSKILLS");
		context.setAttribute("LOCATION", "NOIDA");
		context.setAttribute("TECH", "EDTECH");
		context.setAttribute("JAVA", "AlakhPandey");
		
		//Updation of attribute called Location
		context.setAttribute("LOCATION", "BENGALURU");
		
		//deletion of attribute through Key
		context.removeAttribute("JAVA");

		Enumeration<String> attributeNames = context.getAttributeNames();
		out.println("<body bgcolor='cyan'>");
		out.println("<table border='1' align='center'>");
		out.println("<tr><th>ATTRIBUTENAME</th><th>ATTRIBUTEVALUE</th></tr>");
		while (attributeNames.hasMoreElements()) {
			out.println("<tr>");
			String attributeName = (String) attributeNames.nextElement();
			Object value = context.getAttribute(attributeName);
			out.println("<td>" + attributeName + "</td>");
			out.println("<td>" + value + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body>");

		out.close();
	}

}
