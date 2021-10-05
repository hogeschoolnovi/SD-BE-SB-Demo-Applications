package nl.novi.demo_cors.controller;

import nl.novi.demo_cors.model.Customer;

import nl.novi.demo_cors.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "")
    public ResponseEntity<Object> getCustomers(@RequestParam(required = false) Optional<String> customer_number) {
        return ResponseEntity.ok().body(customerService.getCustomers(customer_number));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Customer>> getCustomer(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(customerService.getCustomerById(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {
        long newId = customerService.createCustomer(customer);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer) {
        customerService.updateCustomer(id, customer);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable("id") int id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

}
