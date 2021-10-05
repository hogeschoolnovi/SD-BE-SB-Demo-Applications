package nl.novi.demo_security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/secure")
    public ResponseEntity<Object> demoSecure() {
        return ResponseEntity.ok("Security demo - ADMIN only");
    }

    @GetMapping("/users_only")
    public ResponseEntity<Object> demoPublic() {
        return ResponseEntity.ok("Security demo - USER and ADMIN access");
    }

    @GetMapping("/all")
    public ResponseEntity<Object> demoEverybody() {
        return ResponseEntity.ok("Landingspagina for everybody");
    }

}
