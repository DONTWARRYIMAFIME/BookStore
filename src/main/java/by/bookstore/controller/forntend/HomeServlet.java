package by.bookstore.controller.forntend;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "HomeServlet", value = "")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String homePage = "frontend/index.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(homePage);
        dispatcher.forward(request, response);
    }

}
