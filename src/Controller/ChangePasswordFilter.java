package Controller;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class ChangePasswordFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ChangePasswordFilter() {
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
		String password=request.getParameter("password");
		String confirm_password=request.getParameter("confirm_password");
		String confirmpassword=request.getParameter("confirmpassword");
		if(password.equals("")==true)
		{
			((HttpServletResponse) response).sendRedirect("/Bankapp/changePasswordFail.jsp");
		}
		else if(confirm_password.equals("")==true)
		{
			((HttpServletResponse) response).sendRedirect("/Bankapp/changePasswordFail.jsp");
		}
		else if(confirmpassword.equals("")==true)
		{
			((HttpServletResponse) response).sendRedirect("/Bankapp/changePasswordFail.jsp");
		}
		else if(password.equals(confirm_password)!=true)
		{
			((HttpServletResponse) response).sendRedirect("/Bankapp/changePasswordFails.jsp");
		}
		else if(password.equals(confirm_password)==true)
		{
		chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
