//notify(String message) → Prints conflict alerts (⚠️).
public class ConflictObserver implements Observer {
    @Override
    public void notify(String message) {
        // Observer receives conflict notification
        System.out.println("⚠️ Conflict Alert: " + message);
    }
}
