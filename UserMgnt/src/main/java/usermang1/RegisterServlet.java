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
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final String  query="insert into usermgmt(id,name,email,mobile,city,gender) values(?,?,?,?,?,?)";

  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	// TODO Auto-generated method stub
	PrintWriter pw=res.getWriter();
	res.setContentType("text/html");
	String id=req.getParameter("id");
	String name=req.getParameter("userName");
	String email=req.getParameter("email");
	String mobile=req.getParameter("mobile");
	//String dob=req.getParameter("dob");
	String city=req.getParameter("city");
	String gender=req.getParameter("gender");
	
	//load JDBC Driver

	try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	}
	catch(ClassNotFoundException cnf){
		cnf.printStackTrace();
	}
	try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","djalok123");
			PreparedStatement ps=con.prepareStatement(query);){
	        ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, mobile);
			//ps.setString(5, dob);
			ps.setString(5, city);
			ps.setString(6, gender);
			int count=ps.executeUpdate();
			if(count==1) {
				pw.println("<h2>RECORD SUCCESFULLY RGISTER</h2>");
	}
			else {
				pw.println("<h2>RECORD NOT RGISTER</h2>");
			}
	}
	catch(SQLException se) {
		pw.println("<h2>"+se.getMessage()+"</h2>");
		se.printStackTrace();
	}catch(Exception e) {
		e.printStackTrace();
	}
	pw.println("<a href='home.html'>Home</a>");
	pw.println("<br>");
	pw.println("<a href='userList'>Book List</a>");
}
  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  doGet(req,res);
	}
}


























