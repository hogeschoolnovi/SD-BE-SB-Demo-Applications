package nl.novi.testassertj.repository;

import nl.novi.testassertj.model.Customer;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void whenFindByName_thenReturnEmployee() {

        // given
        Customer customer = new Customer("Albert", "Einstein");
        entityManager.persist(customer);
        entityManager.flush();

        // when
        Customer found = customerRepository.findByLastName(customer.getLastName());

        // then
        assertThat(found.getLastName()).isEqualTo(customer.getLastName());
    }

}