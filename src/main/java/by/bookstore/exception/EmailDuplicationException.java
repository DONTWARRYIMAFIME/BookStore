package by.bookstore.exception;

public class EmailDuplicationException extends IllegalArgumentException {

    public EmailDuplicationException(String email) {
        super("Email " + email + " is already taken by another user!");
    }

}
