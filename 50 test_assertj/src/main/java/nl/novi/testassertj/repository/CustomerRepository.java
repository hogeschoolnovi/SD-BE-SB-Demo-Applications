package nl.novi.testassertj.repository;

import nl.novi.testassertj.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByLastName(String name);

}
