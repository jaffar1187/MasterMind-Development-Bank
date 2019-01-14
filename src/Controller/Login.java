package Controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

public class Login extends HttpServlet 
{
	private String account_no;

	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		String customer_id=request.getParameter("customer_id");
		String password=request.getParameter("password");
		Model m=new Model();
		m.setCustomer_id(customer_id);
		m.setPassword(password);
		boolean status=m.login();
		account_no=m.getAccount_no();
		if(status==true)
		{
			try 
			{
				String account_no=m.getAccount_no();
				String name=m.getName();
				HttpSession session=request.getSession();
				session.setAttribute("account_no", account_no);
				session.setAttribute("name", name);
				response.sendRedirect("/Bankapp/home.jsp");
			}
			catch (IOException e) 
			{
				System.out.println("Error in redirecting to home");
			}
		}
		else
		{
			try 
			{
				response.sendRedirect("/Bankapp/loginFail.jsp");
			} 
			catch (IOException e) 
			{
				System.out.println("Error in redirecting to loginFailPage");
			}
		}
		
	}
}
