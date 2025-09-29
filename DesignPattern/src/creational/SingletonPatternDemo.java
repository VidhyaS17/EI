package creational;

// Singleton class
class Logger {
    private static Logger instance;//stores single instance.
    private Logger() {}
    public static Logger getInstance() {
        if(instance == null) instance = new Logger();
        return instance;
    }
    public void log(String message) { System.out.println("Log: " + message); }
}

public class SingletonPatternDemo {
    public static void runDemo() {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        logger1.log("Singleton works!");
        System.out.println("Are both instances same? " + (logger1 == logger2));
        System.out.println();
    }
}
