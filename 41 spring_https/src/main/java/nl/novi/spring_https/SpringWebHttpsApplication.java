package nl.novi.spring_https;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringWebHttpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebHttpsApplication.class, args);
	}

	@GetMapping("/")
	public String say_hello() {
		return "Hello world!!! with HTTPS";
	}

}
