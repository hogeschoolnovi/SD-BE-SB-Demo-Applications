package nl.novi.demo_cors.service;

import nl.novi.demo_cors.exceptions.RecordNotFoundException;
import nl.novi.demo_cors.model.Customer;

import nl.novi.demo_cors.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Iterable<Customer> getCustomers(Optional<String> customer_number) {
        if (customer_number.isPresent()) {
            return customerRepository.findAllByCustomerNumber(customer_number.get());
        }
        else {
            return customerRepository.findAll();
        }
    }

    public long createCustomer(Customer customer) {
        Customer newCustomer = customerRepository.save(customer);
        return newCustomer.getId();
    }

    public void updateCustomer(long id, Customer newCustomer) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setFirstName(newCustomer.getFirstName());
            customer.setLastName(newCustomer.getLastName());
            customerRepository.save(customer);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    public void deleteCustomer(long id) {
        if (!customerRepository.existsById(id)) throw new RecordNotFoundException();
        customerRepository.deleteById(id);
    }

    public Optional<Customer> getCustomerById(long id) {
        if (!customerRepository.existsById(id)) throw new RecordNotFoundException();
        return customerRepository.findById(id);
    }

    public boolean customerExistsById(long id) {
        return customerRepository.existsById(id);
    }

}