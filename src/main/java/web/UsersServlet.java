package web;

import dao.implementation.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UsersServlet extends HttpServlet {

//    private static final String index = "userTable.jsp";


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDao userDao = new UserDao();
        request.setAttribute("users", userDao.getAll());
        request.getRequestDispatcher("/userTable.jsp").forward(request, response);

    }

}



