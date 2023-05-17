package web;

import dao.implementation.UserDao;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UsersTable extends HttpServlet {
    private static final long serialVersionUID = 3944378334894360095L;
    private UserDao userDao;

    @Override
    public void init() {
        ServletContext context = getServletContext();
        this.userDao = (UserDao) context.getAttribute("UserDao");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("users", userDao.getAll());
        request.getRequestDispatcher("/userTable.jsp").forward(request, response);

    }

}



