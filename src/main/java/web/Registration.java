package web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Registration extends HttpServlet {
    private static final long serialVersionUID = 4396824053511752912L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response){

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        ServletContext servletContext = request.getServletContext();
//        System.out.println(servletContext.getAttribute("gjkk"));

        request.getRequestDispatcher("/authorization.jsp").forward(request, response);

    }

}
