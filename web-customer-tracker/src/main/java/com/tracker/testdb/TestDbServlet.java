package com.tracker.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TestDbServlet() {

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //Setup connection variables
	    String user = "student";
	    String password = "student";
	    String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?allowPublicKeyRetrieval=true&useSSL=false"; 
	    String driver = "com.mysql.jdbc.Driver";
	    
	    //Get connection
	    try {
	        PrintWriter out = response.getWriter();
	        out.println("Connecting to database: " + jdbcUrl);
	        
	        Class.forName(driver);
	        Connection con = DriverManager.getConnection(jdbcUrl, user, password);
	        
	        out.println("Connected");
	        con.close();
	        
	    } catch(Exception e) {
	        e.printStackTrace();
	        throw new ServletException(e);
	    }
	}

}
