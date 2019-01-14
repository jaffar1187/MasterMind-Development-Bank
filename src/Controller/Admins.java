package Controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Model;

public class Admins extends HttpServlet 
{
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		Model m=new Model();
		String admin_id=request.getParameter("admin_id");
		String admin_password=request.getParameter("admin_password");
		m.setAdmin_id(admin_id);
		m.setAdmin_password(admin_password);
		boolean status=m.adminLogin();
		if(status==true)
		{
			response.sendRedirect("/Bankapp/adminHome.jsp");
		}
		else
		{
			response.sendRedirect("/Bankapp/adminFail.jsp");
		}
	}
}
