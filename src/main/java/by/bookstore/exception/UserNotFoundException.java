package by.bookstore.exception;

public class UserNotFoundException extends IllegalStateException {

    public UserNotFoundException(Long userId) {
        super("User with id( " + userId + ") not found");
    }
}
