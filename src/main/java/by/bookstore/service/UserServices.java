package by.bookstore.service;

import by.bookstore.dao.UserDAO;
import by.bookstore.entity.User;
import by.bookstore.exception.AdminCouldNotBeDeletedException;
import by.bookstore.exception.EmailDuplicationException;
import by.bookstore.exception.UserNotFoundException;
import by.bookstore.validation.UserValidation;

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
import java.util.Optional;

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

        boolean valid = UserValidation.validate();
        if (!valid) {
            /*
                TODO: print message, that shows whats wrong with validation + throw exception about it
             */
        }

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
        User user = Optional.ofNullable(userDAO.findById(userId).get()).orElse(null);

        if (user == null) {
            String message = "Could not find user with ID " + userId;
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
            dispatcher.forward(request, response);

            throw new UserNotFoundException(userId);
        }

        request.setAttribute("user", user);

        String editPage = "user_form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(editPage);
        dispatcher.forward(request, response);
    }

    public void updateUser() throws ServletException, IOException {
        Long userId = Long.parseLong(request.getParameter("id"));
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phoneNumber = request.getParameter("phoneNumber");
        LocalDate dob = LocalDate.parse(request.getParameter("dob"));
        String imageUrl = request.getParameter("imageUrl");
        String password = request.getParameter("password");

        /*
            For debug purpose
         */
        System.out.println(userId);
        System.out.println(email);
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(phoneNumber);
        System.out.println(dob);
        System.out.println(imageUrl);
        System.out.println(password);

        boolean valid = UserValidation.validate();
        if (!valid) {
            /*
                TODO: print message, that shows whats wrong with validation + throw exception about it
             */
        }

        User userByEmail = Optional
                .ofNullable(userDAO.findByEmail(email).get())
                .orElse(null);

        if (userByEmail != null) {
            if (!userByEmail.getUserId().equals(userId)) {
                String message = "Could not update user. User with email " + email + " already exists";
                request.setAttribute("message", message);
                RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
                dispatcher.forward(request, response);

                throw new EmailDuplicationException(email);
            }
        }

        User user = new User(userId, email, firstName, lastName, phoneNumber, dob, imageUrl, password);
        userDAO.update(user);
        listUsers("User information updated successfully!");
    }

    public void deleteUser() throws ServletException, IOException {
        Long userId = Long.parseLong(request.getParameter("id"));

        if (userId == 1) {
            String message = "The default admin user account cannot be deleted";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
            dispatcher.forward(request, response);

            throw new AdminCouldNotBeDeletedException();
        }

        boolean exists = userDAO
                .findById(userId)
                .isPresent();

        if (!exists) {
            String message = "Could not find user with ID " + userId;
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
            dispatcher.forward(request, response);

            throw new UserNotFoundException(userId);
        }

        userDAO.delete(userId);
        listUsers("User has been deleted successfully");
    }

}
