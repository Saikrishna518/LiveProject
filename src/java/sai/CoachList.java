
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


public class CoachList extends HttpServlet
{
   

  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.print("<body background='p.jpg'>");
        out.println("<h2>");
        out.println("List of coaches");
        out.println("</h2><br>");
        out.print("</body>");
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/liveproject","root","root"); 
                PreparedStatement pst=con.prepareStatement("select username,mobile from registration where role='coach'");
               
                
               
                out.print("<html><body>");
                out.print("<table border=1 cellpadding=2 height=100 width=100>");
                
                out.println("<tr><th>CoachName</th><th>Mobile</th>");
                
                 
                  ResultSet rs=pst.executeQuery(); 
           
                 while(rs.next())
                {
                    out.print("<tr>");
                    out.println("<td>" +rs.getString(1)+"</td>");
                    out.println("<td>" +rs.getString(2)+"</td>");
                    
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
        
          
    