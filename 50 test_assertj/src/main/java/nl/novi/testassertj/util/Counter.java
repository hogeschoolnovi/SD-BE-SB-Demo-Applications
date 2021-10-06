package nl.novi.testassertj.util;

import java.util.Arrays;

public class Counter {

    private int total = 0;

    public void add(int getal) {
        total += getal;
    }

    public void add(int[] numbers) {
        this.addWithLoop(numbers);
//        this.addWithStream(numbers);
    }

    public static int addWithLoop(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static int addWithStream(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    public void reset() {
        total = 0;
    }

    public int getTotal() {
        return total;
    }

    public static int getSmallestNumber(int[] numbers) {
        int minimum = numbers[0];
        for (int number : numbers) {
            if (number < minimum) {
                minimum = number;
            }
        }
        return minimum;
    }

    public static int getMaxWithStream(int[] numbers) {
        return Arrays.stream(numbers).max().orElse(0);
    }

}
