package sai;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class RegistrationServlet extends HttpServlet {
	
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 try
         {
		 response.setContentType("text/html");
	         PrintWriter out=response.getWriter();
	   
	      String uname=request.getParameter("uname");
	      String password=request.getParameter("psd");
	      String mobile=request.getParameter("mbl");
	      String role=request.getParameter("role");
	      
	     
              Class.forName("com.mysql.jdbc.Driver");
              Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/liveproject", "root","root");
              
              PreparedStatement pst=con.prepareStatement("insert into registration values(?,?,?,?)");
              
              pst.setString(1,uname);
              pst.setString(2,password);
              pst.setString(3,mobile);
              pst.setString(4,role);
             
              
              int n=pst.executeUpdate();
              
              if(n==1)
              {
                  out.println("<h3>");
                  out.println("Registration successful....");
                  out.println("</h3><br>");
                  out.println("<a href=\"index.html\">Home</a>");
              }
              else
              {
                  out.println("Unsuccess...");
              }
          }
          catch( IOException | ClassNotFoundException | SQLException e)
          {
              System.out.println(e);
          }
          }

}
