package nl.novi.studentcourse.exceptions;

public class ForbiddenException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ForbiddenException() {
        super("You are not authorized to access that resource.");
    }

}