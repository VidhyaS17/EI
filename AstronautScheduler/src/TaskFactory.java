public class TaskFactory {
    // Factory method to create tasks with validation
    public Task createTask(String description, String startTime, String endTime, String priority) {
        // Validate time format (HH:MM)
        // createTask(description, start, end, priority)
        if (!startTime.matches("\\d{2}:\\d{2}") || !endTime.matches("\\d{2}:\\d{2}")) {
            throw new IllegalArgumentException("Error: Invalid time format.");
        }
        return new Task(description, startTime, endTime, priority);// Returns a new Task object
    }
}
