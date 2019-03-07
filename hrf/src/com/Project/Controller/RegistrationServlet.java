package com.Project.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Project.DAO.registrationDAO;
import com.Project.Model.Registration;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public RegistrationServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Registration obj = new Registration();
		
		obj.setFname(request.getParameter("fname"));
		obj.setLname(request.getParameter("lname"));
		obj.setEmail(request.getParameter("email"));
		obj.setPassword(request.getParameter("password"));
		
		registrationDAO rdao = new registrationDAO();
		
		boolean flag = rdao.setUserList(obj);
		
		if(flag)
		{
			RequestDispatcher rd = request.getRequestDispatcher("successRegister.jsp");
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
			rd.forward(request, response);
		}
		
	}

}





