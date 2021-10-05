package nl.novi.dto.request;

import org.springframework.beans.factory.annotation.Required;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class AuthenticationRequest {

    @NotEmpty
    private String username;

    @Size(min=8)
    private String password;

    public AuthenticationRequest() {
    }
    public AuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
