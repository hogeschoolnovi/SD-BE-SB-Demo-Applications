package nl.novi.demo_file_upload.exceptions;

import java.io.Serial;

public class FileStorageException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;
    private String msg;

    public FileStorageException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}