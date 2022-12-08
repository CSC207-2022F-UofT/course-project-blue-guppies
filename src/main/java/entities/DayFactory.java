package entities;

import java.util.HashMap;

/**
 * DayFactory Creates a new Day Object.
 *
 * @author Daniel Livshits
 */
public class DayFactory {

    /**
     * Creates a new Day containing the given tasks and events.
     * Preconditions: The events in Events don't include a time conflict.
     * (This version of the method may be useful for data persistence later.)
     *
     * @param tasks  the tasks for the day, using their unique titles as keys
     * @param events the events for the day, using their unique titles as keys
     * @return a Day with the given map of tasks and map of events.
     */
    public Day createDay(HashMap<String, Task> tasks, HashMap<String, Event> events) {
        return new Day(tasks, events);
    }
}
