package Controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

/**
 * Servlet Filter implementation class TransferFilter
 */
public class TransferFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TransferFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{		
		HttpSession session=((HttpServletRequest) request).getSession();
		String account_no=(String) session.getAttribute("account_no");
		Model m=new Model();
		m.setAccount_no(account_no);
		m.balance();
		String tbalance=m.getBalance();
		String ttransferamount=request.getParameter("transferamount");
		
		if(ttransferamount.equals("")==true)
		{
			((HttpServletResponse) response).sendRedirect("/Bankapp/amount.jsp");

		}
		else 
		{
			Integer transferamount=new Integer(ttransferamount);
			Integer bal = new Integer(tbalance);
			if(transferamount<=0)
			((HttpServletResponse) response).sendRedirect("/Bankapp/invalidAmount.jsp");
			else if(bal>=transferamount)
			chain.doFilter(request, response);
			else
			{
				((HttpServletResponse) response).sendRedirect("/Bankapp/insufficientFunds.jsp");
			}
			
		}
	}
		

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
