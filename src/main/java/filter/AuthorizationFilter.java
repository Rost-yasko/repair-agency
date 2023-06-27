package filter;

import domain.User;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebFilter("/*")
@Slf4j
public class AuthorizationFilter implements Filter {
    private final Map<String, List<Integer>> map = new HashMap<>();

    @Override
    public void init(FilterConfig filterConfig) {
        map.put("/index.jsp", List.of(1, 2, 3));
        map.put("/adminMenu.jsp", List.of(1));
        map.put("/homePage", List.of(1, 2, 3));
        map.put("/usersTable", List.of(1));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession();
        String contextPath = httpServletRequest.getServletPath();

        if (contextPath.contains("/index.jsp") || contextPath.contains("Login") ||
                contextPath.contains("AddUser")) {
            chain.doFilter(request, response);
            return;
        }
        if (session == null || session.getAttribute("user") == null) {
            request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        User user = (User) session.getAttribute("user");
        Integer role = user.getRoleId();
        List<Integer> list = map.get(contextPath);

        if (list != null && list.contains(role)) {
            log.info("role");
            chain.doFilter(request, response);
        } else {
            log.info("403");
            request.getServletContext().getRequestDispatcher("/403.jsp").forward(request, response);
        }

    }

    @Override
    public void destroy() {
    }
}
