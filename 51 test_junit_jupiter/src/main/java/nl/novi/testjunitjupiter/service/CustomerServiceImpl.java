package nl.novi.testjunitjupiter.service;

import nl.novi.testjunitjupiter.model.Customer;
import nl.novi.testjunitjupiter.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Optional<Customer> getCustomer(long id) {
        return customerRepository.findById(id);
    }

    @Override
    public boolean userExists(long id) {
        return customerRepository.existsById(id);
    }

    @Override
    public long createCustomer(Customer customer) {
        Customer newCustomer = customerRepository.save(customer);
        return newCustomer.getId();
    }

    @Override
    public void deleteCustomer(long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void updateCustomer(long id, Customer newCustomer) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer != null) {
            customer.setFirstName(newCustomer.getFirstName());
            customer.setLastName(newCustomer.getLastName());
            customer.setDateOfBirth(newCustomer.getDateOfBirth());
            customerRepository.save(customer);
        }
    }

    @Override
    public Collection<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    @Override
    public Customer getCustomerByLastName(String name) {
        return customerRepository.findByLastName(name);
    }

}
