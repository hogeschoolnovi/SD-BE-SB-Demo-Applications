package nl.novi.testjunitjupiter.util;

public class Counter {

    private int total = 0;

    public void reset() {
        total = 0;
    }

    public void add(int getal) {
        total += getal;
    }

    public void add() {
        total += 1;
    }

    public int getTotal() {
        return total;
    }

}
