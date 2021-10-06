package nl.novi.testassertj.util;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringMethodsTest {

    @Test
    public void simpelTest() {
        String s = "abcdefg";
        String actual = s.toUpperCase();
        String expected = "ABCDEFG";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void simpelTest2() {
        String s = "ABCDEFG";
        String actual = s.toLowerCase();
        String expected = "abcdefg";
        assertThat(actual).isEqualTo(expected);
    }

}
