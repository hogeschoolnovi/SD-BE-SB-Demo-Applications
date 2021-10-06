package nl.novi.testassertj.controller;

import nl.novi.testassertj.model.Customer;
import nl.novi.testassertj.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "")
    public ResponseEntity<Object> getCustomers() {
        return ResponseEntity.ok().body(customerService.getAllCustomers());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getCustomer(@PathVariable long id) {
        return ResponseEntity.ok().body(customerService.getCustomer(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok().body(customerService.createCustomer(customer));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable long id, @RequestBody Customer customer) {
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable long id) {
        return ResponseEntity.noContent().build();
    }

}

