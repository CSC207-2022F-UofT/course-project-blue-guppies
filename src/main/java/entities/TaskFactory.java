package entities;

/**
 * TaskFactory creates a new Task Object.
 *
 * @author Fardin Faruk
 */
public class TaskFactory {
    /**
     * Creates a new Task.
     * Precondition: title is a non-empty string
     *
     * @param title title of the task
     * @return a task created with the given inputs
     */
    public Task createTask(String title) {
        return new Task(title);
    }
}
