package usermang1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editurl")
public class EditUserServlet  extends HttpServlet {

	private static final String  query="UPDATE usermgmt set NAME=?,EMAIL=?,MOBILE=? ,CITY=?,GENDER=? where id=? ";
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//GET BOOK INFO
		int id=Integer.parseInt(req.getParameter("id"));
		
		String name=req.getParameter("name");
		String em=req.getParameter("email");
		String mob=req.getParameter("mobile");
		String cty=req.getParameter("city");
		String gndr=req.getParameter("gender");
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
		}
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","djalok123");
				PreparedStatement ps=con.prepareStatement(query);)      {
		     
		       ps.setString(1, name);
		        ps.setString(2, em);
		        ps.setString(3, mob);
		        ps.setString(4, cty);
		        ps.setString(5, gndr);
		        ps.setInt(6, id);
		       
		        int count=ps.executeUpdate();
		        if(count==1) {
		        	pw.println("<h2>RECORD IS EDITED SUCCESFULLY</h2>");
		        }
		        else {
		        	pw.println("<h2>RECORD IS NOT EDITED SUCCESFULLY</h2>");
		        }
			
			
		}catch(SQLException se) {
			se.printStackTrace();
			pw.println("<h1>" +se.getMessage()+"</h2>");
		}catch(Exception e) {
			e.printStackTrace();
			pw.println("<h1>" +e.getMessage()+"</h2>");
	}
		pw.println("<a href='home.html'>Home</a>");
		pw.println("<br>");
		pw.println("<a href='userList'>Book List</a>");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
