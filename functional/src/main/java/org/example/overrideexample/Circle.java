package org.example.overrideexample;

public class Circle extends ItemImpl {

    private final int radius;

    public Circle(int x, int y, int color, int radius) {
        super(x, y, color);
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Square::circle " + this);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                "} " + super.toString();
    }
}
