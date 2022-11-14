/**
 * TaskFactory creates a new Task Object.
 * Author: Fardin Faruk
 * Modified by: NA
 * Date created: Nov 10, 2022
 * Last Modified: NA
 */
package entities;

public class TaskFactory {
    /**
     * Creates a new Task
     * Precondition: title is a non-empty string
     * @param title title of the task
     * @return a task created with the given inputs
     */
    public Task createTask(String title){
        return new Task(title);
    }


    /**
     * Modify a given Task by changing its title.
     *
     * Precondition: newTitle is a non-empty string, and not equal to any other task
     * scheduled for the same day.
     *
     * @param newTitle title of the task
     * @param task the underlying Task object
     */
    public void modifyTask(String newTitle, Task task) { task.setTitle(newTitle); }

    /**
     * Mark a given Task as completed.
     * @param task the underlying Task object
     */
    public void markTaskAsCompleted(Task task) { task.setCompleted(true); }


}
