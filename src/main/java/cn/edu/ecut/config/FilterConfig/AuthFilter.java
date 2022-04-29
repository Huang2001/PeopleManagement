package cn.edu.ecut.config.FilterConfig;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter
{


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest re=(HttpServletRequest) request;
        HttpSession session=re.getSession(false);
        if(session==null)
        {
            request.getRequestDispatcher("")
        }
    }

    @Override
    public void destroy() {

    }
}
