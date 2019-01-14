package Controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

public class Transfer extends HttpServlet 
{
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		HttpSession session=request.getSession();
		String account_no=(String) session.getAttribute("account_no");
		String transferamount=request.getParameter("transferamount");
		String to=request.getParameter("to");
		Model m=new Model();
		m.setAccount_no(account_no);
		m.setTo(to);
		boolean status=m.transferAmount(transferamount);
		m.balance();
		String balance=m.getBalance();
		session.setAttribute("balance", balance);
		if(status==true)
		{
			response.sendRedirect("/Bankapp/transferSuccess.jsp");
		}
		else
		{
			response.sendRedirect("/Bankapp/transferFail.jsp");
		}
	}
}
