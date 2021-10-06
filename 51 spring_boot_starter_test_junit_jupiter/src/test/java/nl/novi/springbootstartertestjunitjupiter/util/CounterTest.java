package nl.novi.springbootstartertestjunitjupiter.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CounterTest {

    @Test
    void simpelTest() {
        String s = "abcdefg";
        String upper = s.toUpperCase();
        assertEquals("ABCDEFG", upper);
    }

    @Test
    void simpelTest2() {
        String s = "ABCDEFG";
        String actual = s.toLowerCase();
        assertEquals("abcdefg", actual);
    }

    @Test
    void testCounter() {
        // arange
        Counter counter = new Counter();

        // act
        counter.add(10);

        // assert
        assertEquals(10, counter.getTotal());
    }


    @Test
    void testTellerAdd() {
        // given
        Counter counter = new Counter();

        counter.add(45);
        counter.add(67);
        counter.add(32);

        // when
        int actual = counter.getTotal();

        // then
        int expected = 144;
        assertEquals(expected, actual);
    }

}