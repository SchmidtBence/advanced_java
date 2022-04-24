package org.example.overrideexample;

public class Square extends ItemImpl {

    private final int length;

    public Square(int x, int y, int color, int length) {
        super(x, y, color);
        this.length = length;
    }

    @Override
    public void draw() {
        System.out.println("Square::draw " + this);
    }

    @Override
    public String toString() {
        return "Square{" +
                "length=" + length +
                "} " + super.toString();
    }
}
