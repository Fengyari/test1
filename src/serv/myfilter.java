package serv;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Servlet Filter implementation class myfilter
 */
class myservletrequest extends HttpServletRequestWrapper{
	public myservletrequest(HttpServletRequest req) {
		super(req);
	}
	public String getParameter(String name) {
		String value=null;
		
		try {
		value=super.getParameter(name);
		byte buf[]=value.getBytes("iso-8859-1");
		value=new String (buf,"utf-8");
		}
		
		catch(Exception e) {}
		return value;
	}
}


@WebFilter(asyncSupported = true, urlPatterns = { "/*" })//修改为/*，作用为对服务器所有文件进行过滤，优先执行myfilter.

public class myfilter implements Filter {

    /**
     * Default constructor. 
     */
    public myfilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		System.out.println("this is myfilter");
		
		HttpServletRequest rq=(HttpServletRequest)request;
		String s=rq.getRequestURI();//获得网址
		System.out.print("s==="+s);
		if(s.endsWith("login.jsp")) {
			
		}
		else {
			
		}
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
