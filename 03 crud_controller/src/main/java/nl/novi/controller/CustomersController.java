package nl.novi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CustomersController {

    private static Map<Integer, String> customers = new HashMap<>();
    static {
        customers.put(1, "Jansen");
        customers.put(2, "Pietersen");
        customers.put(3, "Klaassen");
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity<Object> getCustomers() {
        return new ResponseEntity<>(customers.entrySet(), HttpStatus.OK);
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getCustomer(@PathVariable("id") int id) {
        return new ResponseEntity<>(customers.get(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") int id) {
        customers.remove(id);
        return new ResponseEntity<>("Customer is successfully deleted", HttpStatus.OK);
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") int id, @RequestBody String customer) {
        customers.remove(id);
        customers.put(id, customer);
        return new ResponseEntity<>("Customer is successfully updated", HttpStatus.OK);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public ResponseEntity<Object> createCustomer(@RequestBody String customer) {
        Integer maxID = Collections.max(customers.keySet());
        customers.put(maxID + 1, customer);
        return new ResponseEntity<>("Customer is successfully created", HttpStatus.CREATED);
    }

}