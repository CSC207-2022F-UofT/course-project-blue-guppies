/**
 * EventFactory creates a new Event object.
 *
 * Author: Anna Myllyniemi
 * Modified by: Daniel Livshits
 * Date created: Nov 9 2022
 * Last modified: Nov 9 2022
 */

package entities;

import java.time.LocalTime;

public class EventFactory {
    /**
     * Creates a new Event.
     *
     * @param title title of the event
     * @param startTime start time of the event
     * @param endTime end time of the event
     * @return an Event created with the given inputs
     *
     * Precondition: startTime < endTime
     */
    public Event createEvent(String title, LocalTime startTime, LocalTime endTime){
        return new Event(title, startTime, endTime);
    }
}
