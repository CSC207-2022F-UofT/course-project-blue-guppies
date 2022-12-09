package entities;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Day class for use in data access.
 *
 * @author Daniel Livshits
 */
public class Day implements Serializable {
    private HashMap<String, Task> tasks;

    private HashMap<String, Event> events;

    /**
     * @param tasks  the tasks to be stored in the day, with their titles as keys
     * @param events the events to be stored in the day, with their titles as keys
     */
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

    public void setTasks(HashMap<String, Task> tasks) {
        this.tasks = tasks;
    }

    public void setEvents(HashMap<String, Event> events) {
        this.events = events;
    }
}
