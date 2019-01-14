<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get Statement</title>
</head>
<body style="background: url(banklogos.jpg);
		background-repeat: no-repeat;
		background-size: 100% 100%;
		background-attachment: fixed;">
<table border="1px" align="center" style="top:0px;
		text-align: center;
		background:blue;
		color:Yellow;
		font-size: 30px;
		font-family:Arial, Helvetica, sans-serif;
		font-style:normal;
		font-weight: bold;
		font-variant: small-caps;">
	<tr>
		<th colspan="3">Credited Transactions</th>
	</tr>
	<tr>	
		<th>Amount</th>
		<th>Time</th>
		<th>From_Account</th>
	</tr>
	<tr>
		<td>
			<%
				session = request.getSession();
				ArrayList al = (ArrayList) session.getAttribute("al");
				Iterator itr = al.iterator();
				while (itr.hasNext() == true) {
					out.println(itr.next() + "<br>");
				}
			%>
		</td>

		<td>
			<%
				session= request.getSession();
				ArrayList al1 = (ArrayList) session.getAttribute("al1");
				Iterator itr1 = al1.iterator();
				while (itr1.hasNext() == true) {
					out.println(itr1.next() + "<br>");
				}
			%>
		</td>
		
		<td>
			<%
				session = request.getSession();
				ArrayList al2 = (ArrayList) session.getAttribute("al2");
				Iterator itr2 = al2.iterator();
				while (itr2.hasNext() == true) {
					out.println(itr2.next() + "<br>");
				}
			%>
		</td>
		
		
		
	</tr>
</table>
<br />
<br />
<br />
<br />







<table border="1px" align="center" style="top:0px;
		text-align: center;
		background:blue;
		color:Yellow;
		font-size: 30px;
		font-family:Arial, Helvetica, sans-serif;
		font-style:normal;
		font-weight: bold;
		font-variant: small-caps;">
	<tr>
		<th colspan="3">Debited Transactions</th>
	</tr>
	<tr>	
		<th>Amount</th>
		<th>Time</th>
		<th>To_Account</th>
	</tr>
	<tr>
		<td>
			<%
				session= request.getSession();
				ArrayList al4 = (ArrayList) session.getAttribute("al4");
				Iterator itr4 = al4.iterator();
				while (itr4.hasNext() == true) {
					out.println(itr4.next() + "<br>");
				}
			%>
		</td>
		
		<td>
			<%
				session = request.getSession();
				ArrayList al5 = (ArrayList) session.getAttribute("al5");
				Iterator itr5 = al5.iterator();
				while (itr5.hasNext() == true) {
					out.println(itr5.next() + "<br>");
				}
			%>
		</td>
		
		<td>
			<%
				session = request.getSession();
				ArrayList al3 = (ArrayList) session.getAttribute("al3");
				Iterator itr3 = al3.iterator();
				while (itr3.hasNext() == true) {
					out.println(itr3.next() + "<br>");
				}
			%>
		</td>
		
		
		
	</tr>
</table>

</body>
</html>