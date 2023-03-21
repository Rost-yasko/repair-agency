package web;

import dao.implementation.UserDao;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        UserDao userDao = new UserDao();
        User user = userDao.getByLogin(login);
        if (user != null && user.getPassword().equals(password)) {
            request.getRequestDispatcher("/homePage.jsp").forward(request, response);
            return;
        }

        request.setAttribute("message", "Your login or password is incorrect");
        request.setAttribute("Login", login);
        request.setAttribute("Password", password);
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);

    }
}
