package by.bookstore.exception;

public class UserNotFoundException extends IllegalStateException {

    public UserNotFoundException(Long userId) {
        super("User with id( " + userId + ") not found");
    }

    public UserNotFoundException(String email) {
        super("User with email( " + email + ") not found");
    }
}
