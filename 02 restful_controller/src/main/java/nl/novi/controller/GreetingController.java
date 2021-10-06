package nl.novi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Value("${message.default.welcome}")
    private String welcomeMessage;

    @Value("${message.default.goodbye}")
    private String goodByeMessage;

    @GetMapping(value = "/welcome")
    public String welcome() {
        return welcomeMessage;
    }

    @RequestMapping(value = "/goodbye", method = RequestMethod.GET)
    public String bye() {
        return goodByeMessage;
    }

}
