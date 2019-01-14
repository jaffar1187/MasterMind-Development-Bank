<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link href="home.css" rel="stylesheet" type="text/css" />
</head>
<body>
<p>Welcome <% session=request.getSession();out.println(session.getAttribute("name"));%></p>
<table border="5px" align="center">
<tr>
<td> <a href="Balance"><img src="balances.jpg" height="190px" width="260px" /></a></td>
<td><a href="/Bankapp/changePassword.jsp"><img src="password.jpg" height="190px" width="260px"/></a></td>
<td><a href="/Bankapp/transfer.jsp"><img src="transfer.jpg" height="190px" width="260px"/></a></td>
</tr>

<tr>
<td><a href="GetStatement"><img src="statement.jpg" height="190px" width="260px"/></a></td>
<td><a href="/Bankapp/Loan.jsp"><img src="Loan.jpg" height="190px" width="260px"/></a></td>
<td><a href="Logout"><img src="logout.jpg" height="190px" width="260px"/></a></td>
</tr>
<tr>
<td colspan="3"><a href="deactivate.jsp"><img src="accountdeactivate.png" height="190px" width="790px"/></a></td>
</tr>

</table>
</body>
</html>