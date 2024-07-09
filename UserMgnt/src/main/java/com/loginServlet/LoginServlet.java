package com.loginServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Loginservlet")
public class LoginServlet extends HttpServlet {
	private static final String  query="select email from usermgmt where email=? and name=?";

@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	PrintWriter pw=res.getWriter();
	res.setContentType("text/html");
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
		}
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","djalok123");
				PreparedStatement ps=con.prepareStatement(query);){
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				RequestDispatcher rd=req.getRequestDispatcher("welcome.html");
				rd.forward(req, res);
			}
			else {
				pw.println("<h1 color=red size=18>login failed</h1>");
			}
	}	catch(SQLException se) {
		pw.println("<h2>"+se.getMessage()+"</h2>");
		se.printStackTrace();
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}
