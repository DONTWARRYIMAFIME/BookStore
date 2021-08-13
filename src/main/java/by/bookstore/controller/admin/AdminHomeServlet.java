package by.bookstore.controller.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminHomeServlet", value = "/admin/")
public class AdminHomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String homePage = "index.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(homePage);
        dispatcher.forward(request, response);
    }

}
