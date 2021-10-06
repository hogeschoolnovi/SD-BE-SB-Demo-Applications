package nl.novi.springbootstartertestjunitjupiter.repository;

import nl.novi.springbootstartertestjunitjupiter.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByLastName(String name);

}
