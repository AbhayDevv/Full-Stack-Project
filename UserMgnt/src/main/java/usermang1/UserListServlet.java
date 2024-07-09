package usermang1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/userList")
public class UserListServlet extends HttpServlet {
	private static final String  query="SELECT ID,NAME,EMAIL,MOBILE,CITY,GENDER FROM usermgmt";
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	PrintWriter pw=res.getWriter();
	res.setContentType("text/html");
	pw.println("<link rel='stylesheet'  href='css/bootstrap.css'></link>");

	try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	}
	catch(ClassNotFoundException cnf){
		cnf.printStackTrace();
	}
	try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","djalok123");
			PreparedStatement ps=con.prepareStatement(query);){
		ResultSet rs=ps.executeQuery();
		pw.println("<table class='table table-hover table-striped'>");
		pw.println("<tr>");
		pw.println("<th> Id</th>");
		pw.println("<th>User Name</th>");
		pw.println("<th>EMAIL</th>");
		pw.println("<th>MOBILE</th>");
		pw.println("<th>CITY</th>");
		pw.println("<th>GENDER</th>");
		pw.println("<th>EDIT</th>");
		pw.println("<th>DELETE</th>");
		pw.println("</tr>");
		while(rs.next()) {
			pw.println("<tr>");
			pw.println("<td>"+ rs.getString(1) +"</td>");
			pw.println("<td>"+ rs.getString(2) +"</td>");
			pw.println("<td>"+ rs.getString(3) +"</td>");
			pw.println("<td>"+ rs.getString(4) +"</td>");
			pw.println("<td>"+ rs.getString(5) +"</td>");
			pw.println("<td>"+ rs.getString(6) +"</td>");
			pw.println("<td><a href='editScreen?id="+rs.getInt(1)+"'>EDIT</a></td>");
			pw.println("<td><a href='deleteurl?id="+rs.getInt(1)+"'>DELETE</a></td>");
			
             pw.println("</tr>");
		}
		pw.println("</table>");
		
	}
	catch(SQLException se) {
		pw.println("<h2 clss='bg-danger text-light text-center'>"+se.getMessage()+"</h2>");
		se.printStackTrace();
	}catch(Exception e) {
		e.printStackTrace();
	}
	pw.println("<a href='home.html'>Home</a>");

}
  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  doGet(req,res);
	}
}
