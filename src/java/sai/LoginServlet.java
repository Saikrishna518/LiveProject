package sai;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet 
{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	      response.setContentType("text/html");
              try
		{
	      PrintWriter out=response.getWriter();
	   
	      String uname=request.getParameter("uname");
	      String password=request.getParameter("psd");
              String role=request.getParameter("role");
              
              
	      
	      if(password.equals("sai")&&uname.equals("sai")&&role.equals("Admin"))
	      {
                  out.println("welcome " +uname);
	    	  RequestDispatcher rd=request.getRequestDispatcher("AdminServlet");
                  rd.forward(request,response);
	      }
	      else
	      {
                  if(Validate.checkUser(uname,password,role))
                  {
                      RequestDispatcher rd = request.getRequestDispatcher("PlayerServlet");
                      rd.forward(request, response);
                  }
                  else
                  {
	    	       out.print("invalid username and password");
                       RequestDispatcher rd=request.getRequestDispatcher("/Login.jsp");
                       rd.include(request,response);
                  
                   }
              
            }
                }
              
              catch(IOException | ServletException e)
              {
                      System.out.println(e);
              }
        
        }
}


