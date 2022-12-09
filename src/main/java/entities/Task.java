package entities;

import java.io.Serializable;

/**
 * Task class for use in data access.
 *
 * @author Fardin Faruk
 */
public class Task implements Serializable {
    private String title;
    private boolean completed;

    /**
     * @param title the title of this task
     */
    public Task(String title) {
        this.title = title;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
