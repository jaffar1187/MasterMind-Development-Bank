<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link href="banklogo.css" rel="stylesheet" type="text/css" />
</head>
<body>
<p style="text-align: center;
		background:blue;
		color:Yellow;
		font-size: 30px;
		font-family:Arial, Helvetica, sans-serif;
		font-style:normal;
		font-weight: bold;
		font-variant: small-caps;">MasterMind Development Bank</p>
<form action="Admins">
<table align="center">
<tr>
<td>Admin_Id</td>
<td><input type="text"  autofocus name="admin_id"/></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="admin_password"/></td>
<td><input type="submit" value="Login"/></td>
<td><input type="reset"></td>
</tr>
</table>
</form>
</body>
</html>