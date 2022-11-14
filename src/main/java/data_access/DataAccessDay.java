package data_access;

import entities.Event;
import entities.Task;

import java.util.HashMap;

public class DataAccessDay {
    private HashMap<String, Task> tasks;

    private HashMap<String, Event> events;

    //this constructor will be useful for data persistence later.
    protected DataAccessDay(HashMap<String, Task> tasks, HashMap<String, Event> events) {
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
