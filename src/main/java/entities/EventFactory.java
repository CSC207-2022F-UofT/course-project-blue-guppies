package entities;

import java.time.LocalTime;

/**
 * EventFactory creates a new Event object.
 * @author Anna Myllyniemi
 */
public class EventFactory {
    /**
     * Creates a new Event.
     * Precondition: startTime < endTime
     * @param title title of the event
     * @param startTime start time of the event
     * @param endTime end time of the event
     * @return an Event created with the given inputs
     */
    public Event createEvent(String title, LocalTime startTime, LocalTime endTime){
        return new Event(title, startTime, endTime);
    }
}
