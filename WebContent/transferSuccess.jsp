<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TransactionSuccessful</title>
<link href="transferSuccess.css" rel="stylesheet" type="text/css" />
</head>
<body>
<p>Transaction Successful</p>
<p>Current Balance:
<%
session=request.getSession();
out.println(session.getAttribute("balance"));
%>
</p>
</body>
</html>