package in.pwskills.akash.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/scount")
public class SessionCountApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Integer value = (Integer) session.getAttribute("hitcount");
		if (session.isNew()) {
			if (value == null) {
				value = 1;
			} else {
				value++;
			}
		} 
		session.setAttribute("hitcount", value);
		out.println("<h1>The number of requests in current session is ::" + value + "</h1>");
		out.close();
	}
}
