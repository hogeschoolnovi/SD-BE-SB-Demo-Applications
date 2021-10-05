package nl.novi.controller;

import nl.novi.model.Customer;
import nl.novi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @GetMapping(value = "")
    public ResponseEntity<Object> getCustomers() {
        return ResponseEntity.ok().body(customerRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getCustomer(@PathVariable("id") long id) {
        if (customerRepository.existsById(id)) {
            return ResponseEntity.ok().body(customerRepository.findById(id));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {
        long newId = customerRepository.save(customer);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable("id") long id, @RequestBody Customer newCustomer) {
        if (customerRepository.existsById(id)) {
            Customer customer = customerRepository.findById(id).get();
            customer.setFirstName(newCustomer.getFirstName());
            customer.setLastName(newCustomer.getLastName());
            customerRepository.save(customer);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable("id") long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

}
