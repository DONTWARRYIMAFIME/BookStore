package by.bookstore.exception;

public class AdminCouldNotBeDeletedException extends IllegalStateException {

    public AdminCouldNotBeDeletedException() {
        super("You are trying to delete admin account. This account could not be deleted");
    }

}
