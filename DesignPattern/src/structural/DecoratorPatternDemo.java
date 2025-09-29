package structural;

// Component
interface Coffee { String getDescription(); double cost(); }//returns description, cost() → returns price.

// Concrete component
class SimpleCoffee implements Coffee {
    public String getDescription() { return "Simple Coffee"; }//Provides base coffee description and cost.
    public double cost() { return 5.0; }
}

// Decorator
abstract class CoffeeDecorator implements Coffee {//Holds a reference to a Coffee object.
    protected Coffee coffee;
    CoffeeDecorator(Coffee coffee) { this.coffee = coffee; }
}

// Concrete decorator
class MilkDecorator extends CoffeeDecorator {
    MilkDecorator(Coffee coffee) { super(coffee); }
    public String getDescription() { return coffee.getDescription() + ", Milk"; }
    public double cost() { return coffee.cost() + 2.0; }//Adds "Milk" to description and 2.0 to cost.
}

public class DecoratorPatternDemo {
    public static void runDemo() {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " $" + coffee.cost());
        Coffee milkCoffee = new MilkDecorator(coffee);
        System.out.println(milkCoffee.getDescription() + " $" + milkCoffee.cost());
        System.out.println();
    }
}
