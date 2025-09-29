import behavioral.ObserverPatternDemo;
import behavioral.StrategyPatternDemo;
import creational.SingletonPatternDemo;
import creational.FactoryPatternDemo;
import structural.AdapterPatternDemo;
import structural.DecoratorPatternDemo;

public class MainApp {
    //Prints headers for each pattern type,Calls runDemo() of each demo class in sequence.
    // Combines all outputs in one console run.
    public static void main(String[] args) {
        System.out.println("=== Behavioral Patterns ===");
        ObserverPatternDemo.runDemo();
        StrategyPatternDemo.runDemo();

        System.out.println("=== Creational Patterns ===");
        SingletonPatternDemo.runDemo();
        FactoryPatternDemo.runDemo();

        System.out.println("=== Structural Patterns ===");
        AdapterPatternDemo.runDemo();
        DecoratorPatternDemo.runDemo();
    }
}
