package nl.novi.fileupload.exception;

import java.io.Serial;

public class FileStorageException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public FileStorageException() {
        super();
    }

    public FileStorageException(String message) {
        super(message);
    }

}