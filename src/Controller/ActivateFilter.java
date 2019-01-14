package Controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import model.Model;

/**
 * Servlet Filter implementation class ActivateFilter
 */
public class ActivateFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ActivateFilter() {
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
		String account_no=request.getParameter("account_no");
		Model m=new Model();
		m.setAccount_no(account_no);
		boolean status=m.validateActivation();
		if(account_no.equals("")==true)
		((HttpServletResponse) response).sendRedirect("/Bankapp/changePasswordFail.jsp");
		else if(status==true)
		chain.doFilter(request, response);
		else
		((HttpServletResponse) response).sendRedirect("/Bankapp/invalidAccountFail.jsp");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
