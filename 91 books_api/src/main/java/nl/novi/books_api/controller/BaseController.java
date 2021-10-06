package nl.novi.books_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class BaseController {

    @GetMapping(value = "/")
    public String hello() {
        return "For more information navigate to https://localhost:8443/info.";
    }

    @ResponseStatus(value = HttpStatus.I_AM_A_TEAPOT)
    @GetMapping(value = "/coffee")
    public String coffee() { return ""; }

}
