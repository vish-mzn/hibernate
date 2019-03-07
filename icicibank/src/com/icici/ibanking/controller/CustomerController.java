package com.icici.ibanking.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icici.ibanking.model.CustomerPojo;
import com.icici.ibanking.service.CustomerServiceImpl;


@WebServlet("/servlet/CustomerController")
public class CustomerController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();


	public CustomerController() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ac = request.getParameter("act");

		if (ac != null) 
		{
			if (ac.equals("displayCustomerForm")) {
				displayCustomerForm(request, response);
			} else if (ac.equals("listCustomer")) {
				listCustomer(request, response);
			} else if (ac.equals("deleteCustomer")) {
				deleteCustomer(request, response);
			} else if (ac.equals("showEditForm")) {
				showEditForm(request, response);
			} else {
				listCustomer(request, response);
			}

		} 
		else 
		{
			listCustomer(request, response);
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ac = request.getParameter("act");
		if (ac != null) 
		{
			if (ac.equals("createCustomer")) {
				createCustomer(request, response);
			} else if (ac.equals("updateCustomer")) {
				updateCustomer(request, response);
			} else {
			}
		} 
		else {
			System.out.println("no acion specified...");
		}
	}

	private void createCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
		try {
			String f = request.getParameter("fname");
			String l = request.getParameter("lname");
			int a = Integer.parseInt(request.getParameter("age").trim());

			CustomerPojo customerPojo = new CustomerPojo();
			customerPojo.setF(f);
			customerPojo.setL(l);
			customerPojo.setA(a);
			customerServiceImpl.createCustomer(customerPojo);
			response.sendRedirect("" + getServletContext().getContextPath() + "/servlet/CustomerController?act=listCustomer");
			// RequestDispatcher rd =
			// request.getRequestDispatcher("WEB-INF/view/listCustomer.jsp");
			// rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
		try {
			String id = request.getParameter("id");
			String f = request.getParameter("fname");
			String l = request.getParameter("lname");
			int a = Integer.parseInt(request.getParameter("age").trim());

			CustomerPojo customerPojo = new CustomerPojo();
			customerPojo.setId(Integer.parseInt(id.trim()));
			customerPojo.setF(f);
			customerPojo.setL(l);
			customerPojo.setA(a);
			customerServiceImpl.updateCustomer(customerPojo);
			response.sendRedirect("" + getServletContext().getContextPath() + "/servlet/CustomerController?act=listCustomer");
			// RequestDispatcher rd =
			// request.getRequestDispatcher("WEB-INF/view/listCustomer.jsp");
			// rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<CustomerPojo> customerList = customerServiceImpl.listCustomer();
			request.setAttribute("customerList", customerList);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/listCustomer.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void displayCustomerForm(HttpServletRequest request, HttpServletResponse response) {
		try {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/customerCreation.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) 
	{
		try {
			String cusId = request.getParameter("id");
			CustomerPojo customerPojo = customerServiceImpl.getCustomer(Integer.parseInt(cusId.trim()));
			request.setAttribute("customerPojo", customerPojo);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/showEditForm.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void deleteCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
		try {
			String cusId = request.getParameter("id");
			customerServiceImpl.deleteCustomer(Integer.parseInt(cusId.trim()));
			response.sendRedirect("" + getServletContext().getContextPath() + "/servlet/CustomerController?act=listCustomer");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
