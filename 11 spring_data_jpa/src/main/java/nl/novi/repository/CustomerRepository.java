package nl.novi.repository;

import nl.novi.model.Customer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    public Iterable<Customer> findAllByLastName(String name);




//    @Query(value = "SELECT * FROM customers c WHERE LOWER(c.first_name) = LOWER(:name)", nativeQuery = true)
//    Optional<Customer> getAllByFirstName(@Param("name") String name);

//    @Query("SELECT c FROM customers c WHERE LOWER(c.first_name) = LOWER(:name)")
//    Optional<Customer> getAllByFirstName(@Param("name") String name);

}