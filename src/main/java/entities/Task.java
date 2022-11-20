/**
 * Task class.
 * Author: Fardin Faruk
 * Modified by: NA
 * Date created: Nov 10, 2022
 * Last Modified: NA
 */
package entities;

import java.io.Serializable;

public class Task implements Serializable {
    private String title;
    private boolean completed;

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
