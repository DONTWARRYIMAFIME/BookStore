package by.bookstore.service;

import by.bookstore.dao.UserDAO;
import by.bookstore.entity.User;
import by.bookstore.exception.EmailDuplicationException;
import by.bookstore.exception.UserNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class UserServices {

    private final UserDAO userDAO;
    private final HttpServletRequest request;
    private final HttpServletResponse response;

    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStore");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        userDAO = new UserDAO(entityManager);
    }

    public UserServices(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public void listUsers() throws ServletException, IOException {
        listUsers(null);
    }

    public void listUsers(String message) throws ServletException, IOException {
        List<User> users = userDAO.findAll();
        request.setAttribute("users", users);

        if (message != null) {
            request.setAttribute("message", message);
        }

        String listPage = "user_list.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
        requestDispatcher.forward(request, response);
    }

    public void createUser() throws ServletException, IOException {
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phoneNumber = request.getParameter("phoneNumber");
        LocalDate dob = LocalDate.parse(request.getParameter("dob"));
        String imageUrl = request.getParameter("imageUrl");
        String password = request.getParameter("password");

        System.out.println(email);
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(phoneNumber);
        System.out.println(dob);
        System.out.println(imageUrl);
        System.out.println(password);
        
        boolean userExists = userDAO.findByEmail(email).isPresent();

        if (userExists) {
            String message = "Could not create a user. User with email " + email + " already exists";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
            dispatcher.forward(request, response);

            throw new EmailDuplicationException(email);
        }

        User user = new User(email, firstName, lastName, phoneNumber, dob, imageUrl, password);
        userDAO.save(user);
        listUsers("New user was created successfully!");

    }


    public void editUser() throws ServletException, IOException {
        Long userId = Long.parseLong(request.getParameter("id"));
        User user = userDAO.findById(userId);

        if (user == null) {
            throw new UserNotFoundException(userId);
        }

        /*
        Checking if is works by now
         */
        System.out.println(user.getFirstName() + " " + user.getLastName());

        request.setAttribute("user", user);

        String editPage = "user_form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(editPage);
        dispatcher.forward(request, response);
    }
}
