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
     * Modify a given Task by changing it's title
     * Precondition: newTitle is a non-empty string
     * @param newTitle title of the task
     */
    public void modifyTask(String newTitle, Task task) { task.setTitle(newTitle); }
}
