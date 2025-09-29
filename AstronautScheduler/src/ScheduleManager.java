// File: ScheduleManager.java
import java.util.*;
import java.util.logging.*;

public class ScheduleManager {
    private static ScheduleManager instance; // Singleton → one manager instance.
    private final List<Task> tasks; // Observer → conflict notifications.
    private final List<Observer> observers;
   
  

    // Logger for application usage and errors
    private static final Logger logger = Logger.getLogger(ScheduleManager.class.getName());

    private ScheduleManager() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    // Singleton: only one instance of ScheduleManager
    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers(String message) {
        for (Observer obs : observers) {
            obs.notify(message);
        }
    }

    // Add a new task with overlap validation
   // addTask(Task task)---Validates overlap,
             //If conflict → notifies observers.
             //Else → adds and sorts tasks by time.

    public void addTask(Task task) {
        for (Task existing : tasks) {
            if (isOverlapping(task, existing)) {
                notifyObservers("Task conflicts with existing task \"" + existing.getDescription() + "\".");
                logger.warning("Conflict detected while adding task: " + task.getDescription());
                return;
            }
        }
        tasks.add(task);
        tasks.sort(Comparator.comparing(Task::getStartTime)); // sort by start time
        System.out.println("Task added successfully. No conflicts.");
        logger.info("Task added: " + task.getDescription());
    }

    // Remove task by description
    // removeTask(String description)
   // Deletes a task if found, else shows error.
    public void removeTask(String description) {
        Task toRemove = tasks.stream()
                             .filter(t -> t.getDescription().equalsIgnoreCase(description))
                             .findFirst()
                             .orElse(null);
        if (toRemove != null) {
            tasks.remove(toRemove);
            System.out.println(" Task removed successfully.");
            logger.info("Task removed: " + description);
        } else {
            System.out.println(" Error: Task not found.");
            logger.warning("Attempted to remove non-existent task: " + description);
        }
    }

    // View all tasks
    // viewTasks()
         // Prints all tasks sorted by start time.
    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
            logger.info("Viewed tasks - none found.");
            return;
        }
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    // Mark a task as completed
    // markTaskCompleted(String description)
    // Marks a task as completed.
    public void markTaskCompleted(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equalsIgnoreCase(description)) {
                task.markCompleted();
                System.out.println("Task marked as completed.");
                logger.info("Task marked completed: " + description);
                return;
            }
        }
        System.out.println("Error: Task not found.");
        logger.warning("Attempted to complete non-existent task: " + description);
    }

    // View tasks by priority
    // viewTasksByPriority(String priority)
    public void viewTasksByPriority(String priority) {
        boolean found = false;
        for (Task task : tasks) {
            if (task.getPriority().equalsIgnoreCase(priority)) {
                System.out.println(task);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No tasks found with priority: " + priority);
            logger.info("No tasks found with priority: " + priority);
        }
    }

    // Helper: check if two tasks overlap
    private boolean isOverlapping(Task t1, Task t2) {
        return (t1.getStartTime().compareTo(t2.getEndTime()) < 0 &&
                t1.getEndTime().compareTo(t2.getStartTime()) > 0);
    }
}
