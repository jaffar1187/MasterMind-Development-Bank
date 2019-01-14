package Controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

public class Activate extends HttpServlet 
{
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		Model m=new Model();
		String account_no=request.getParameter("account_no");
		m.setAccount_no(account_no);
		boolean status=m.activate();
		HttpSession session=request.getSession();
		session.setAttribute("account_no",account_no);
		if(status==true)
		{
			response.sendRedirect("/Bankapp/activationSuccess.jsp");
		}
		else
		{
			response.sendRedirect("/Bankapp/activationFail.jsp");
		}
	}
}
