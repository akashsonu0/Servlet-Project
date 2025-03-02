package in.pwskills.akash.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/client")
public class ClientServerInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static {
		System.out.println("Loading :: ClientServerInfo.class file is loading..");
	}
       
    
    public ClientServerInfo() {
        System.out.println("Instantiation :: ClientServerInfo()...");
    }
    
    @Override
    public void init() throws ServletException {
    	System.out.println("Initialization :: init()");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RequestProcessing :: ClientServerInfo.doGet()");
		
		PrintWriter out = response.getWriter();
		
		//server details
		String serverName = request.getServerName();
		int serverPort = request.getServerPort();
		
		//client details
		String remoteAddr = request.getRemoteAddr();
		String remoteHost = request.getRemoteHost();
		int remotePort = request.getRemotePort();
		
		out.println("<body bgcolor='cyan' align='centre'>");
		out.println("<table border ='1'>");
		out.println("<tr>");
		   out.println("<th>SERVERNAME</th>");
		   out.println("<th>SERVERPORT</th>");
		   out.println("<th>REMOTEADDR</th>");
		   out.println("<th>REMOTEHOST</th>");
		   out.println("<th>REMOTEPORT</th>");
		out.println("<tr/>");
		
		
		out.println("<tr>");
			out.println("<td>" + serverName + "</td>");
			out.println("<td>" + serverPort + "</td>");
			out.println("<td>" + remoteAddr + "</td>");
			out.println("<td>" + remoteHost + "</td>");
			out.println("<td>" + remotePort + "</td>");
		out.println("<tr/>");
		
		out.println("</table>");
		out.println("</body>");
		out.close();	
		
		
	}

}
