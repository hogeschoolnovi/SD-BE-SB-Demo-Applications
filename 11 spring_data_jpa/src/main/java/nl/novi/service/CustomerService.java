package nl.novi.service;

import nl.novi.model.Customer;

import java.util.Collection;
import java.util.Optional;

public interface CustomerService {

    public abstract long createCustomer(Customer customer);
    public abstract void updateCustomer(long id, Customer customer);
    public abstract void deleteCustomer(long id);
    public abstract Iterable<Customer> getCustomers();
    public abstract Iterable<Customer> getCustomersByLastName(String name);
    public abstract Optional<Customer> getCustomerById(long id);
    public abstract boolean customerExistsById(long id);

}