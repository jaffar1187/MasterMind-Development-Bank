package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

public class Deactivate extends HttpServlet 
{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		String account_no=(String) session.getAttribute("account_no");
		String value=request.getParameter("confirmation");
		if(value.equals("deactivate")==true)
		{
			Model m=new Model();
			m.setAccount_no(account_no);
			boolean status=m.deactivate();
			if(status==true)
			{
				response.sendRedirect("/Bankapp/deactivationSuccess.jsp");
			}
			else
			{
				response.sendRedirect("/Bankapp/deactivationFail.jsp");
			}

		}
		else
		{
			response.sendRedirect("/Bankapp/home.jsp");
		}
		
		
	}
}
