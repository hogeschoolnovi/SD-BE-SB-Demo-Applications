package nl.novi.springbootstartertestassertj.util;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CounterTest {

    @Test
    public void testCounterAdd() {

        // arange
        Counter counter = new Counter();

        counter.add(45);
        counter.add(67);
        counter.add(32);

        // act
        int actual = counter.getTotal();

        // assert
        int expected = 144;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void addWithLoopTest() {
        int[] getallen = new int[] {1,2,3};
        int actual = Counter.addWithLoop(getallen);
        int expected = 6;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void addWithStreamTest() {
        int[] getallen = new int[] {1,2,3};
        int actual = Counter.addWithStream(getallen);
        int expected = 6;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void getSmallestNumberTest() {
        int[] getallen = new int[] {1,2,3};
        int actual = Counter.getSmallestNumber(getallen);
        int expected = 1;
        assertThat(actual).isEqualTo(expected);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getSmallestNumberWithEmptyArrayTest() {
        int[] numbers = new int[] {};
        int actual = Counter.getSmallestNumber(numbers);
    }

    @Test
    public void testTellerInstantiate() {
        Counter counter = new Counter();
        assertThat(counter).isNotNull();
        assertThat(counter.getTotal()).isEqualTo(0);
    }

}