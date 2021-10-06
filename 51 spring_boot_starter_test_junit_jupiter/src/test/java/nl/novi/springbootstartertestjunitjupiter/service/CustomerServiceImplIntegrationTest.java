package nl.novi.springbootstartertestjunitjupiter.service;

import nl.novi.springbootstartertestjunitjupiter.SpringBootStarterTestJunitJupiterApplication;
import nl.novi.springbootstartertestjunitjupiter.model.Customer;
import nl.novi.springbootstartertestjunitjupiter.repository.CustomerRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


@SpringBootTest()
@ContextConfiguration(classes={SpringBootStarterTestJunitJupiterApplication.class})
public class CustomerServiceImplIntegrationTest {

    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepository;

    @Mock
    Customer customer;

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testGetCustomerByLastName() {
        customer = new Customer("Albert", "Einstein");

        Mockito
                .when(customerRepository.findByLastName(customer.getLastName()))
                .thenReturn(customer);

        String name = "Einstein";
        String expected = "Albert Einstein";

        Customer found = customerService.getCustomerByLastName(name);

        assertEquals(expected, found.getFullName());
    }

    @Test
    public void testGetCustomerByLastName2() {
        customer = new Customer("Albert", "Einstein");

        Mockito
                .doReturn(customer)
                .when(customerRepository)
                .findByLastName("Einstein");

        String name = "Einstein";
        String expected = "Albert Einstein";

        Customer found = customerService.getCustomerByLastName(name);

        assertEquals(expected, found.getFullName());
    }

    @Test
    void testGetCustomerByLastNameNotFound() {
        String name = "EinsteinXXX";

        // Setup our mock repository
        Mockito
                .doReturn(null).when(customerRepository)
                .findByLastName(name);

        // Execute the service call
        Customer found = customerService.getCustomerByLastName(name);

        // Assert the response
        assertNull(found, "Widget should not be found");
    }


}
