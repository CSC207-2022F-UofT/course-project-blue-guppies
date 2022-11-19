/**
 * Task class for use in data access.
 * Author: Daniel Livshits
 * Modified by: Daniel Livshits
 * Date created: Nov 14, 2022
 * Last Modified: Nov 17, 2022
 */
package data_access;

import java.io.Serializable;

public class DataAccessTask implements Serializable {
    private String title;
    private boolean completed;

    public DataAccessTask(String title) {
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
