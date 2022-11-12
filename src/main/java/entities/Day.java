/**
 * Day Class.
 * Author: Daniel Livshits
 * Created: Nov 9, 2022
 * Last Modified: Nov 9, 2022
 */
package entities;

import java.util.HashMap;

public class Day {
    private final HashMap<String, Task> tasks;

    private final HashMap<String, Event> events;

    //this constructor will be useful for data persistence later.
    protected Day(HashMap<String, Task> tasks, HashMap<String, Event> events) {
        this.tasks = tasks;
        this.events = events;
    }

    public HashMap<String, Task> getTasks() {
        return tasks;
    }

    public HashMap<String, Event> getEvents() {
        return events;
    }
}
