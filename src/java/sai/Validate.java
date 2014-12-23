package sai;

import java.sql.*;

public class Validate
 {
 
     public static boolean checkUser(String uname,String password,String role) 
     {
      boolean st =false;
      try{

	
         Class.forName("com.mysql.jdbc.Driver");

 	 
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/liveproject","root","root");
         PreparedStatement ps =con.prepareStatement("select * from registration where username=? and password=? and role=?");
         ps.setString(1, uname);
         ps.setString(2, password);
         ps.setString(3, role);
         
         ResultSet rs =ps.executeQuery();
         st = rs.next();
        
      }
      catch(ClassNotFoundException | SQLException e)
      {
        System.out.println(e);
      }
         return st;                 
  }   
}
