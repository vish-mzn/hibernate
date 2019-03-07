package com.icici.ibanking.service;

import java.util.List;

import com.icici.ibanking.dao.CustomerDao;
import com.icici.ibanking.model.CustomerPojo;

public class CustomerServiceImpl {

	
	public void createCustomer(CustomerPojo customerPojo) {
		CustomerDao customerDao = new CustomerDao();
		customerDao.createCustomer(customerPojo);
	}
	
	public void updateCustomer(CustomerPojo customerPojo) {
		CustomerDao customerDao = new CustomerDao();
		customerDao.updateCustomer(customerPojo);
	}

	public void deleteCustomer(int cusId) {
		CustomerDao customerDao = new CustomerDao();
		customerDao.deleteCustomer(cusId);
	}
	
	public CustomerPojo getCustomer(int cusId) {
		CustomerDao customerDao = new CustomerDao();
		return customerDao.getCustomer(cusId);
	}

	public List<CustomerPojo> listCustomer() {
		List<CustomerPojo> customerList=null;
		try {
			CustomerDao customerDao = new CustomerDao();
		    customerList = customerDao.listCustomer();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerList;
	}

}
