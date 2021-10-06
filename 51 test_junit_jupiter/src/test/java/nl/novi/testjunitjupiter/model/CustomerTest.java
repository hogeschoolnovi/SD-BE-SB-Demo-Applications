package nl.novi.testjunitjupiter.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;


class CustomerTest {

    private Customer customer;

    @BeforeEach
    void setUp() {
        this.customer = new Customer("Albert", "Einstein");
        this.customer.setDateOfBirth(LocalDate.of( 1879, 3, 14));
    }

    @Test
    void testGetFullName() {
        String expectedFullName = "Albert Einstein";
        String actualFullName = this.customer.getFullName();
        assertEquals(expectedFullName, actualFullName);
    }

    @Test
    void testGetAge() {
        int expectedAge = 76;
        int actualAge = customer.getAge(LocalDate.of(1955,4,18));
        assertEquals(expectedAge, actualAge);
    }

}