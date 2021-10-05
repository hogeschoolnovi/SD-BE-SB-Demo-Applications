package nl.novi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @GetMapping(value = "/customers")
    public ResponseEntity<Object> getCustomers() {
        return ResponseEntity.ok("Placeholder for customers endpoints");
    }

}
