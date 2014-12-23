
package sai;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdminServlet extends HttpServlet
{
   

  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        request.getRequestDispatcher("link.jsp").include(request, response);
        
        
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/liveproject","root","root"); 
                PreparedStatement pst=con.prepareStatement("select * from registration");
               
                out.println("<h1>welcome Admin</h1>");
               
                out.print("<html><body>");
                out.print("<table border=1 cellpadding=2 height=100 width=100>");
                
                out.println("<tr><th>username</th><th>password</th><th>mobile</th><th>role</th></tr>");
                
                 
                  ResultSet rs=pst.executeQuery(); 
           
                 while(rs.next())
                {
                    out.print("<tr>");
                    out.println("<td>" +rs.getString(1)+"</td>");
                    out.println("<td>" +rs.getString(2)+"</td>");
                    out.println("<td>" +rs.getString(3)+"</td>");
                    out.println("<td>" +rs.getString(4)+"</td>");
                    out.println("</tr>");
                           
                    
                }
                 out.println("</table>");
                 out.println("</body></html>");
                 
              
            
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }
    }
}
        
          
    