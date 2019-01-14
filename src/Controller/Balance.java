package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

public class Balance extends HttpServlet
{
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session=request.getSession();
		String account_no=(String) session.getAttribute("account_no");
		Model m=new Model();
		m.setAccount_no(account_no);
		boolean status=m.balance();
		String balance = m.getBalance();
		if(status==true)
		{	
			try
			{
				session.setAttribute("balance", balance);
				response.sendRedirect("/Bankapp/balance.jsp");
			} 
			catch (IOException e)
			{
				System.out.println("Problem in redirecting to balance.jsp");
			}
		}
		else
		{
			try 
			{
				response.sendRedirect("/Bankapp/balanceFail.jsp");
			} 
			catch (IOException e) 
			{
				System.out.println("Problem in redirecting to balanceFail.jsp");
			}
		}
	}
}
