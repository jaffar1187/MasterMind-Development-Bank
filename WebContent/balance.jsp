<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Balance</title>
<link href="balance.css" rel="stylesheet" type="text/css" />
</head>
<body>
<p>
<%
session=request.getSession();
out.println("Current Balance:"+session.getAttribute("balance"));
%>
</p>

</body>
</html>