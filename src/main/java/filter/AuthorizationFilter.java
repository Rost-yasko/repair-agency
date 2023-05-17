package filter;

import domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("/*")
public class AuthorizationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpSession session = httpServletRequest.getSession(false);
        String contextPath = ((HttpServletRequest) request).getServletPath();
        System.out.println("dfghjkl");
        System.out.println(contextPath);
        if (session != null && session.getAttribute("user") !=null) {
            User user = (User) session.getAttribute("user");
//            user.getRoleId();
        }
        chain.doFilter(request, response);


    }

    @Override
    public void destroy() {
    }
}
