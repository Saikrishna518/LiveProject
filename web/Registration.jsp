<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
<title>Registration</title>
<script type="text/javascript">
 function Validate()
 {
    var x = document.forms["regform"]["uname"].value;
    if (x == null || x == "")
    {
        alert("Username must be filled out");
        return false;
    }
    var x = document.forms["regform"]["psd"].value;
    if (x == null || x == "")
    {
        alert("password must be filled out");
        return false;
    }
    var x = document.forms["regform"]["psd1"].value;
    if (x == null || x == "")
    {
        alert("confirm password must be filled out");
        return false;
    }
    var frm = document.forms["regform"];
    if(frm.psd.value != frm.psd1.value)
    {
        alert("The Password and confirm password does not match!");
        return false;
   }
   var x = document.forms["regform"]["mbl"].value;
    if (x == null || x == "")
    {
        alert("phone number must be filled out");
        return false;
    }
    var x = document.forms["regform"]["role"].value;
    if (x == null || x == "")
    {
        alert("Select the role");
        return false;
    }
   
 }
</script>
</head>
<body>
    <h1>Registration</h1><hr>
<form action="RegistrationServlet" method="get" name="regform" onsubmit="return Validate()">
Username :<input type="text" name="uname"><br><br>
Password :<input type="password" name="psd"><br><br>
Confirm Password :<input type="password" name="psd1"><br><br>
Mobile Number :<input type="text" name="mbl"><br><br>
Select Role:<select name="role">
<option value="Player">Player
<option value="Coach">Coach
<option value="Guardian">Guardian
</select>
<br><br>
 <input type="submit" value="Register">
 <input type="reset" value="Reset">    
 </form>
</body>
</html>
