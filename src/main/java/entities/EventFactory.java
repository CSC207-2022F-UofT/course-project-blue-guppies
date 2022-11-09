/**
 * EventFactory creates a new Event object.
 *
 * Author: Anna Myllyniemi
 * Date created: Nov 9 2022
 */

package entities;

import java.time.LocalTime;

public class EventFactory {
    /**
     * Creates a new Event.
     *
     * @param title title of the event
     * @param startTime start time of the event represented in miliseconds
     * @param endTime end time of the event represented in miliseconds
     * @return an Event created with the given inputs
     *
     * Precondition 1: startTime and endTime are created using the milisecond Time constructor
     * Precondition 2: startTime < endTime
     * Precondition 3: 0 <= startTime.getTime() < 86400000 and 0 <= endTime.getTime() < 86400000
     *
     */
    public Event createEvent(String title, LocalTime startTime, LocalTime endTime){
        return new Event(title, startTime, endTime);
    }
}
