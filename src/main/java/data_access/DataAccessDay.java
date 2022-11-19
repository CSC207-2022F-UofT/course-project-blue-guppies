/**
 * Day Class for use in data access.
 * Author: Daniel Livshits
 * Created: Nov 14, 2022
 * Last Modified: Nov 17, 2022
 */
package data_access;

import java.io.Serializable;
import java.util.HashMap;

public class DataAccessDay implements Serializable {
    private HashMap<String, DataAccessTask> tasks;

    private HashMap<String, DataAccessEvent> events;

    //this constructor will be useful for data persistence later.
    protected DataAccessDay(HashMap<String, DataAccessTask> tasks, HashMap<String, DataAccessEvent> events) {
        this.tasks = tasks;
        this.events = events;
    }

    public HashMap<String, DataAccessTask> getTasks() {
        return tasks;
    }

    public HashMap<String, DataAccessEvent> getEvents() {
        return events;
    }

    public void setTasks(HashMap<String, DataAccessTask> tasks){
        this.tasks = tasks;
    }

    public void setEvents(HashMap<String, DataAccessEvent> events) {
        this.events = events;
    }
}
