package nl.novi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController {

    @GetMapping(value = "/")
    public String hello() {
        return "Hello everybody";
    }

}
