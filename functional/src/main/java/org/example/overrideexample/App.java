package org.example.overrideexample;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Engine engine=new Engine();

        engine.addItem(new Circle(10,19,3,12));
        engine.addItem(new Circle(50,19,4,6));
        engine.addItem(new Square(12,33,44,5));

        engine.draw();
    }
}
