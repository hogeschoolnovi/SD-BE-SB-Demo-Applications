package nl.novi.springbootstartertestassertj.repository;

import nl.novi.springbootstartertestassertj.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByLastName(String name);

}
