public class MainApp {
    public static void main(String[] args) {
        ScheduleManager manager = ScheduleManager.getInstance();
        TaskFactory factory = new TaskFactory();
        manager.addObserver(new ConflictObserver());

        System.out.println(" Astronaut Daily Schedule Organizer ");

        try {
            // === Positive Cases ===
            System.out.println("\n--- Positive Cases ---");
            manager.addTask(factory.createTask("Morning Exercise", "07:00", "08:00", "High"));
            manager.addTask(factory.createTask("Team Meeting", "09:00", "10:00", "Medium"));
            manager.viewTasks(); // view all tasks
            manager.removeTask("Morning Exercise");
            manager.addTask(factory.createTask("Lunch Break", "12:00", "13:00", "Low"));

            // Mark task as completed
            manager.markTaskCompleted("Team Meeting");

            // View by priority
            manager.viewTasksByPriority("Low");

            // === Negative Cases ===
            System.out.println("\n--- Negative Cases ---");
            manager.addTask(factory.createTask("Training Session", "09:30", "10:30", "High")); // conflict
            manager.removeTask("Non-existent Task"); // removing non-existent
            manager.addTask(factory.createTask("Invalid Time Task", "25:00", "26:00", "Low")); // invalid time
            manager.addTask(factory.createTask("Overlap Task", "08:30", "09:30", "Medium")); // conflict

            // View tasks when empty scenario
            ScheduleManager emptyManager = ScheduleManager.getInstance();
            emptyManager.viewTasks(); // already has tasks, so not empty in this run

        } catch (Exception e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }
}
