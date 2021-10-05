package nl.novi.repository;

import nl.novi.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    int count();
    int save(Customer customer);
    int update(Customer customer);
    int deleteById(Long id);
    List<Customer> findAll();
    Optional<Customer> findById(Long id);
    Boolean existsById(Long id);

    List<Customer> findByLastName(String name);
    String getNameById(Long id);

}