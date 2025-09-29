package creational;

// Product interface
interface Shape { void draw(); }//--abstract method for all shapes.

// Concrete products
class Circle implements Shape { public void draw() { System.out.println("Drawing Circle"); } }//draw() → prints the type of shape being drawn.
class Rectangle implements Shape { public void draw() { System.out.println("Drawing Rectangle"); } }

// Factory
class ShapeFactory {
    public static Shape getShape(String type) {
        if(type.equalsIgnoreCase("CIRCLE")) return new Circle();
        else if(type.equalsIgnoreCase("RECTANGLE")) return new Rectangle();
        return null;
    }
}

public class FactoryPatternDemo {
    public static void runDemo() {//Requests shapes from the factory and calls draw() on them.
        Shape shape1 = ShapeFactory.getShape("Circle");
        shape1.draw();
        Shape shape2 = ShapeFactory.getShape("Rectangle");
        shape2.draw();
        System.out.println();
    }
}
