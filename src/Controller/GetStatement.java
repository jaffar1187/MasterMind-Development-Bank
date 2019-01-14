package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

public class GetStatement extends HttpServlet 
{
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		HttpSession session=request.getSession();
		String account_no=(String) session.getAttribute("account_no");
		Model m=new Model();
		m.setAccount_no(account_no);
		ArrayList al=new ArrayList();
		ArrayList al1 =new ArrayList();
		ArrayList al2=new ArrayList();
		ArrayList al3;
		ArrayList al4;
		ArrayList al5;
		al=m.getStatement();
		al5=m.getAl5();
		if((al.isEmpty()==true)&&(al5.isEmpty()==true))
		{
			response.sendRedirect("/Bankapp/getStatementFail.jsp");
		}
		else
		{
			session.setAttribute("al", al);
			al1=m.getAl1();
			session.setAttribute("al1", al1);
			al2=m.getAl2();
			session.setAttribute("al2", al2);
			al3=m.getAl3();
			session.setAttribute("al3", al3);
			al4=m.getAl4();
			session.setAttribute("al4", al4);
			session.setAttribute("al5", al5);
			response.sendRedirect("/Bankapp/getStatement.jsp");
		}
			
	}
}
