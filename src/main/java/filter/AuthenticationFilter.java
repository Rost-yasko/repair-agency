package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        if (request.getServletPath().equals("/Login") || request.getServletPath().equals("/AddUser") ||
                request.getServletPath().equals("/index.jsp")) {
            chain.doFilter(request, response);
            return;
        }
        if (session == null || session.getAttribute("user") == null) {
            request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);

        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
