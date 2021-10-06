package nl.novi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class BaseController {

    @GetMapping(value = "/")
    public String sayHelloWorld() {
        return "Hello world!";
    };

    @GetMapping(value = "/hello")
    public String sayHello(@RequestParam(name = "name", required = false) String name) {
        if (name == null) {
            return "Hello world!";
        }
        else {
            return "Hello " + name + "!";
        }
    };

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam(name = "name") Optional<String> name) {
        if (name.isEmpty()) {
            return "Hi!";
        }
        else {
            return "Hi " + name.get() + "!";
        }
    };


}
