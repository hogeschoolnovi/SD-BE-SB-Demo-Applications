package nl.novi.testjunitjupiter.service;

import nl.novi.testjunitjupiter.model.Customer;

import java.util.Collection;
import java.util.Optional;

public interface CustomerService {

    Collection<Customer> getAllCustomers();
    Optional<Customer> getCustomer(long id);
    boolean userExists(long id);
    long createCustomer(Customer customer);
    void deleteCustomer(long id);
    void updateCustomer(long id, Customer newCustomer);
    Customer getCustomerByLastName(String name);

}
