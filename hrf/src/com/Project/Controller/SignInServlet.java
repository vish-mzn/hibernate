package com.Project.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Project.DAO.SignInDAO;
import com.Project.Model.Registration;

@WebServlet("/SignInServlet")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SignInServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		SignInDAO sdao = new SignInDAO();
		ArrayList<Registration> list = sdao.getUserList();
		
		for(Registration r : list)
		{
			if(email.equals(r.getEmail()) && password.equals(r.getPassword()))
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("validation.jsp");
				dispatcher.forward(request, response);
				return;
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("signin.jsp");
		dispatcher.forward(request, response);
		return;
		
	}

}
