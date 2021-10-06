package nl.novi.testjunitjupiter.repository;

import nl.novi.testjunitjupiter.TestJunitJupiterApplication;
import nl.novi.testjunitjupiter.model.Customer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;


@DataJpaTest
@ContextConfiguration(classes={TestJunitJupiterApplication.class})
class CustomerRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void testFindByLastLast() {
        // given
        Customer customer = new Customer("Albert", "Einstein");
        entityManager.persist(customer);
        entityManager.flush();

        // when
        Customer found = customerRepository.findByLastName(customer.getLastName());

        // then
        String expected = "Albert Einstein";
        String actual = found.getFullName();
        assertEquals(expected, actual);
    }

}