package nl.novi.controller;

import nl.novi.dto.request.AuthenticationRequest;
import nl.novi.dto.response.AuthenticationResponse;
import nl.novi.service.UserAuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {

    UserAuthenticateService userAuthenticateService;

    @Autowired
    public AuthenticationController(UserAuthenticateService userAuthenticateService) {
        this.userAuthenticateService = userAuthenticateService;
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {

        AuthenticationResponse authenticationResponse = userAuthenticateService.authenticateUser(authenticationRequest);

        return ResponseEntity.ok(authenticationResponse);
    }

}
