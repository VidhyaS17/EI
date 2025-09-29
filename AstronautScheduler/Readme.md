# Java Task Scheduler Application

A **Task Scheduler** application built in **Java** that allows users to add, remove, view, and manage tasks with features like conflict detection and priority handling.  
The project demonstrates the use of **Software Design Patterns**:  
- **Singleton Pattern** – Ensures only one `ScheduleManager` exists.  
- **Factory Pattern** – Simplifies creation of `Task` objects.  
- **Observer Pattern** – Alerts users when conflicts occur.  

---

## Features

###  Functional Requirements
- Add a new task with description, start time, end time, and priority level.  
- Remove an existing task.  
- View all tasks sorted by start time.  
- Validate that new tasks do not overlap with existing tasks.  
- Provide appropriate error messages for invalid operations.  

###  Optional Features
- Edit an existing task.  
- Mark tasks as completed.  
- View tasks by priority level.  

###  Non-Functional Requirements
- Graceful exception handling.  
- Optimized for performance.  
- Logging mechanism to track application usage and errors.  

---

##  Design Patterns Used
1. **Singleton Pattern**  
   - `ScheduleManager` class follows Singleton.  
   - Only one schedule manager instance manages all tasks.  

2. **Factory Pattern**  
   - `TaskFactory` creates task objects.  
   - Provides flexibility for extending task types in the future.  

3. **Observer Pattern**  
   - `ConflictObserver` listens for conflicts.  
   - Alerts the user if a new task overlaps with an existing one.  

---

##  Example Runs

###  Positive Cases
Add Task("Morning Exercise", "07:00", "08:00", "High")
➡️ Output: Task added successfully. No conflicts.

Add Task("Team Meeting", "09:00", "10:00", "Medium")
➡️ Output: Task added successfully. No conflicts.

View Tasks
➡️ Output:
07:00 - 08:00: Morning Exercise [High]
09:00 - 10:00: Team Meeting [Medium]

Remove Task("Morning Exercise")
➡️ Output: Task removed successfully.

shell
Copy code

###  Negative Cases
Add Task("Training Session", "09:30", "10:30", "High")
➡️ Output: Error: Task conflicts with existing task "Team Meeting".

Remove Task("Non-existent Task")
➡️ Output: Error: Task not found.

Add Task("Invalid Time Task", "25:00", "26:00", "Low")
➡️ Output: Error: Invalid time format.
