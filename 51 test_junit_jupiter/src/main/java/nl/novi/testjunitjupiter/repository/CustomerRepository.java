package nl.novi.testjunitjupiter.repository;

import nl.novi.testjunitjupiter.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByLastName(String name);

}
