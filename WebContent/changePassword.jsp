<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<link href="changePassword.css" rel="stylesheet" type="text/css" />

</head>
<body>
<form action="ChangePassword">
<table align="center">
<tr>
	<td>Current Password</td>
	<td><input autofocus type="password" name="confirmpassword"/></td>
</tr>
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />

<tr>
<td>New Password</td>
<td><input type="password" name="password"/></td>
</tr>
<tr>
<td>Confirm New Password</td>
<td><input type="password" name="confirm_password"/></td>
<th colspan="2"><input type="submit" value="Update"/></th>
<td><input type="reset"></td>
</tr>
</table>
</form>
</body>
</html>