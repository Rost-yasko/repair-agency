package web;

import dao.implementation.UserDao;
import domain.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;


public class AddUser extends HttpServlet {
    private static final long serialVersionUID = -3518906220458644609L;
    private UserDao userDao;

    @Override
    public void init() {
        ServletContext context = getServletContext();
        this.userDao = (UserDao) context.getAttribute("UserDao");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String balance = request.getParameter("balance");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (userDao.getByLogin(login) != null) {
            request.setAttribute("message", "This login is in usage");
            request.setAttribute("firstName", firstName);
            request.setAttribute("lastName", lastName);
            request.setAttribute("email", email);
            request.setAttribute("phone", phone);
            request.setAttribute("balance", balance);
            request.getRequestDispatcher("/registration.jsp").forward(request, response);
            return;
        }

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPhone(phone);
        user.setBalance(new BigDecimal(balance));
        user.setLogin(login);
        user.setPassword(password);
        user.setRoleId(3);

        userDao.create(user);
        request.setAttribute("message", "You are successful registered, enter your login and password");
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/registration.jsp").forward(request, response);

    }
}
