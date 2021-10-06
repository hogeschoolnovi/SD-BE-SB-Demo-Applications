package nl.novi.springbootstartertestassertj.model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp() {
        this.customer = new Customer("Albert", "Einstein");
        this.customer.setDateOfBirth(LocalDate.of( 1879, 3, 14));
    }

    @Test
    public void testGetFullName() {
        String expectedFullName = "Albert Einstein";
        String actualFullName = this.customer.getFullName();
        assertThat(actualFullName).isEqualTo(expectedFullName);  // AssertJ
    }

    @Test
    public void testGetAge() {
        int expectedAge = 76;
        int actualAge = customer.getAge(LocalDate.of(1955,4,18));
        assertThat(actualAge).isEqualTo(expectedAge);  // AssertJ
    }

}