package com.icici.ibanking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.icici.ibanking.model.CustomerPojo;

public class CustomerDao {

	private Connection jdbcConnection;
	private PreparedStatement statement;
	private Statement st;
	ResultSet resultSet;
	private String jdbcURL = "jdbc:mysql://localhost:3306/ctsdb";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";
	List<CustomerPojo> customerPojoList = null;

	private void connect() throws SQLException 
	{
		if (jdbcConnection == null) 
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
		}
	}
	
	void prepareStatementClose() {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void statementClose() {
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void connectionClose() {
		try {
			if (jdbcConnection != null) {
				jdbcConnection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void resultSetClose() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

	public void createCustomer(CustomerPojo customerPojo) 
		{
		try {
			System.out.println("Inside customerDao");
			String sql = "INSERT INTO customer (fname, lname, age) VALUES (?, ?, ?)";
			connect();
			statement = jdbcConnection.prepareStatement(sql);
			statement.setString(1, customerPojo.getF());
			statement.setString(2, customerPojo.getL());
			statement.setInt(3, customerPojo.getA());

			int rowInserted = statement.executeUpdate();
			System.out.println(rowInserted);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			prepareStatementClose();
			connectionClose();
		}
	}

	public CustomerPojo getCustomer(int customerId) {
		CustomerPojo customerPojo = null;
		try {
			String sql = "SELECT * FROM customer WHERE cusid = ?";
			connect();
			PreparedStatement statement = jdbcConnection.prepareStatement(sql);
			statement.setInt(1, customerId);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				int cusid = resultSet.getInt("cusid");
				String fname = resultSet.getString("fname");
				String lname = resultSet.getString("lname");
				int age = resultSet.getInt("age");

				customerPojo = new CustomerPojo();
				customerPojo.setId(cusid);
				customerPojo.setF(fname);
				customerPojo.setL(lname);
				customerPojo.setA(age);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resultSetClose();
			prepareStatementClose();
			connectionClose();
		}
		return customerPojo;
	}

	public void updateCustomer(CustomerPojo customerPojo) {

		try {
			String sql = "UPDATE customer SET fname = ?, lname = ?, age = ?";
			sql += " WHERE cusid = ?";
			connect();

			PreparedStatement statement = jdbcConnection.prepareStatement(sql);
			
			statement.setString(1, customerPojo.getF());
			statement.setString(2, customerPojo.getL());
			statement.setInt(3, customerPojo.getA());
			statement.setInt(4, customerPojo.getId());

			int rowUpdateStatus = statement.executeUpdate();

			System.out.println("No of rows updated...." + rowUpdateStatus);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			prepareStatementClose();
			connectionClose();
		}

	}

	public List<CustomerPojo> listCustomer() throws SQLException {
		try {
			System.out.println("Inside customerDao");
			customerPojoList = new ArrayList<>();
			String sql = "SELECT * FROM customer";
			connect();
			st = jdbcConnection.createStatement();
			resultSet = st.executeQuery(sql);

			while (resultSet.next()) {
				int cusid = resultSet.getInt("cusid");
				String fname = resultSet.getString("fname");
				String lname = resultSet.getString("lname");
				int age = resultSet.getInt("age");

				CustomerPojo customerPojo = new CustomerPojo();
				customerPojo.setId(cusid);
				customerPojo.setF(fname);
				customerPojo.setL(lname);
				customerPojo.setA(age);
				customerPojoList.add(customerPojo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resultSetClose();
			statementClose();
			connectionClose();
		}
		return customerPojoList;
	}

	public void deleteCustomer(int cusId)  
	{
		try {
			String sql = "DELETE FROM customer where cusid = ?";
			connect();
			statement = jdbcConnection.prepareStatement(sql);
			statement.setInt(1, cusId);
			int count = statement.executeUpdate();
			System.out.println("No of rows deleted...." + count);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			prepareStatementClose();
			connectionClose();
		}
	}

}
