package sai;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class PlayerServlet extends HttpServlet
{

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("link.jsp").include(request, response);
        String uname=request.getParameter("uname");
        String role=request.getParameter("role");
        
        out.print("<html>");
        out.print("<body background='p.jpg'>");
        out.println("<h1>");
        out.println("Welcome  " +uname);
        out.println("</h1>");
        out.print("</body>");
        out.print("</html>");
        
        if(role.equals("Player"))
        {
        request.getRequestDispatcher("CoachList").include(request, response);
        }
        else
        {
            request.getRequestDispatcher("PlayerList").include(request, response);
        }
        
      }  
}