package nl.novi.testassertj.service;

import nl.novi.testassertj.model.Customer;
import nl.novi.testassertj.repository.CustomerRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;


@TestConfiguration
@RunWith(SpringRunner.class)
public class CustomerServiceImplIntegrationTest {

    @TestConfiguration
    static class CustomerServiceImplTestContextConfiguration {
        @Bean
        public CustomerService customerService() {
            return new CustomerServiceImpl();
        }
    }

    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepository;

    @Before
    public void setUp() {
        Customer customer = new Customer("Albert", "Einstein");

        Mockito
                .when(customerRepository.findByLastName(customer.getLastName()))
                .thenReturn(customer);

    }

    @Test
    public void testGetEmployeeByName() {
        String name = "Einstein";
        Customer found = customerService.getCustomerByLastName(name);

        assertThat(found.getLastName()).isEqualTo(name);
    }

}
