package entities;

import java.util.HashMap;

public class Day{
    private final HashMap<String, Task> tasks;

    private final HashMap<String, Event> events;

    public Day(){
        this.tasks = new HashMap<>();
        this.events = new HashMap<>();
    }

    public HashMap<String, Task> getTasks() {
        return tasks;
    }

    public HashMap<String, Event> getEvents() {
        return events;
    }
}
