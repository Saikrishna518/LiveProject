package sai;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
public class Logout extends HttpServlet
{  
        protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                                throws ServletException, IOException {  
            response.setContentType("text/html");  
            try (PrintWriter out = response.getWriter()) 
            {
                request.getRequestDispatcher("link.jsp").include(request, response);
                
                HttpSession session=request.getSession();
                session.invalidate();
                
                out.print("You are successfully logged out!");
                request.getRequestDispatcher("Login.jsp").include(request, response);
                out.close();
            }  
    }  
}  