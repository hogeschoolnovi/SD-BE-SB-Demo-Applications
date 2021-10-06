package nl.novi;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.boot.SpringApplication.*;

@SpringBootApplication
@RestController
public class RestfulControllerApplication {

    public static void main(String[] args) {
        run(RestfulControllerApplication.class, args);
    }

}
