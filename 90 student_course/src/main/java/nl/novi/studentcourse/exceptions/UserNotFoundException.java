package nl.novi.studentcourse.exceptions;

public class UserNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UserNotFoundException() {
        super("Cannot find specified user.");
    }

}
