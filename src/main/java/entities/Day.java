/**
 * Day Class.
 * Author: Daniel Livshits
 * Modified By: Daniel Livshits
 * Created: Nov 9, 2022
 * Last Modified: Nov 19, 2022
 */
package entities;

import java.io.Serializable;
import java.util.HashMap;

public class Day implements Serializable {
    private HashMap<String, Task> tasks;

    private HashMap<String, Event> events;

    //this constructor will be useful for data persistence later.
    public Day(HashMap<String, Task> tasks, HashMap<String, Event> events) {
        this.tasks = tasks;
        this.events = events;
    }

    public HashMap<String, Task> getTasks() {
        return tasks;
    }

    public HashMap<String, Event> getEvents() {
        return events;
    }

    public void setTasks(HashMap<String, Task> tasks){
        this.tasks = tasks;
    }

    public void setEvents(HashMap<String, Event> events) {
        this.events = events;
    }
}
