package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("gopost entering");
		
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username!=null || password!=null) {
		
		if(username.equals("vishesh") && password.equals("vishesh@99"))
		{
			HttpSession session = request.getSession();
			session.setAttribute("name", username);
			response.sendRedirect("jsp/login.jsp");
		}
		else
		{
		   out.println("<script type=\"text/javascript\">");
		   out.println("alert('Username or Password incorrect');");
		   out.println("location='welcome.jsp';");
		   out.println("</script>");
		}
		
	}else {
		response.sendRedirect("jsp/welcome.jsp");
	}
	}

}
