package nl.novi.studentcourse.exceptions;

public class BadRequestException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BadRequestException() {
        super("Request is not valid.");
    }

}