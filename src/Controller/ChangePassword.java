package Controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

public class ChangePassword extends HttpServlet 
{
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		HttpSession session=request.getSession();
		String account_no=(String) session.getAttribute("account_no");
		String password=request.getParameter("password");
		String confirmpassword=request.getParameter("confirmpassword");
		Model m=new Model();
		m.setAccount_no(account_no);
		m.setPassword(password);
		m.setConfirmpassword(confirmpassword);
		boolean status=m.changePassword();
		if(status==true)
		{
			response.sendRedirect("/Bankapp/changePasswordSuccess.jsp");
		}
		else
		{
			response.sendRedirect("/Bankapp/currentChangePasswordFail.jsp");
		}
	
		
	}
}
