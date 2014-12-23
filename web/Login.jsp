<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Login</title>
<body background="log.png">
<script type="text/javascript">
function validateForm() 
{
     var x = document.forms["loginform"]["uname"].value;
    if (x == null || x == "")
    {
        alert("Username must be filled out");
        return false;
    }
    var x = document.forms["loginform"]["psd"].value;
    if (x == null || x == "")
    {
        alert("Password must be filled out");
        return false;
    }
}
</script>
</head>
<body>
    <form action="LoginServlet" method="get" name="loginform" onsubmit="return validateForm()">
        <h1><font color="brown">Login</font></h1>
<hr/>
<font color="yellow">Username: <input type="text" name="uname"><br><br>
Password: <input type="password" name="psd"><br><br>
Select Role:<select name="role">
<option value="Admin">Admin
<option value="Player">Player
<option value="Coach">Coach
<option value="Guardian">Guardian
    </font>
</select><br><br>
<input type="submit" value="Send"> &nbsp; &nbsp;
<input type="reset" value="Reset">
</form>
</body>
</html>
