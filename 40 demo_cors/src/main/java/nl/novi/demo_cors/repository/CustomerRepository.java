package nl.novi.demo_cors.repository;

import nl.novi.demo_cors.model.Customer;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Collection<Customer> findAllByCustomerNumber(String customer_number);

}