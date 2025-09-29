package behavioral;
import java.util.*;

// Observer interface
interface TaskObserver {
    void update(String task);
}

// Subject class
class TaskSubject {
    private List<TaskObserver> observers = new ArrayList<>();
    //TaskObserver (interface)--Method: update(String task) → called when the subject notifies observers.
    public void addObserver(TaskObserver observer) { observers.add(observer); }
    
    // removeObserver(TaskObserver observer) → removes an observer.
    public void removeObserver(TaskObserver observer) { observers.remove(observer); }
   
    public void notifyObservers(String task) { // notifyObservers(String task) → calls update on all registered observers.
        for(TaskObserver obs : observers) obs.update(task);
    }


    // addTask(String task) → adds a task and calls notifyObservers to alert observers.
    public void addTask(String task) {
        System.out.println("Task added: " + task);
        notifyObservers(task);
    }
}

// Concrete observer
class EmailNotifier implements TaskObserver {
    public void update(String task) { System.out.println("Email sent for task: " + task); }
}

public class ObserverPatternDemo {
    public static void runDemo() {
        TaskSubject subject = new TaskSubject();
        EmailNotifier notifier = new EmailNotifier();
        subject.addObserver(notifier);
        subject.addTask("Design Patterns Demo");
        System.out.println();
    }
}
