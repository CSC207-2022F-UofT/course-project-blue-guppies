package create_event_use_case;

import entities.Event;
import data_access.WeekDataAccess;

import java.time.LocalTime;
import java.util.HashMap;

/**
 * Data access class for the Create Event use case. Implements the methods given
 * in the Ds Gateway.
 *
 * @author Anna Myllyniemi
 */
public class CreateEventDataAccess extends WeekDataAccess implements CreateEventDsGateway {

    /**
     * Check whether there already exists an event with the specified title for the
     * given title.
     *
     * @param title    The title of the event to be created.
     * @param dayIndex The index of the Day instance we want to create an event for.
     * @return whether there exists an Event with the title specified in the Day
     * instance at dayIndex.
     */
    @Override
    public boolean eventExistsByTitle(String title, int dayIndex) {
        return days.get(dayIndex).getEvents().containsKey(title);
    }

    /**
     * Check whether there exists an Event in the Day instance at dayIndex with
     * overlapping times as the range given by startTime and endTime.
     *
     * @param dayIndex  The index of the Day instance we want to create an event for.
     * @param startTime The start time of the event we want to create.
     * @param endTime   The end time of the event we want to create.
     * @return whether there exists an Event in the Day instance at dayIndex with
     * overlapping times as the range given by startTime and endTime.
     */
    @Override
    public boolean isTimeConflict(int dayIndex, LocalTime startTime, LocalTime endTime) {
        HashMap<String, Event> eventsToCheck = days.get(dayIndex).getEvents();
        for (String existingEventTitle : eventsToCheck.keySet()) {
            LocalTime start = eventsToCheck.get(existingEventTitle).getStartTime();
            LocalTime end = eventsToCheck.get(existingEventTitle).getEndTime();
            if (startTime.isBefore(end) && endTime.isAfter(start)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Create an Event using the instance attributes of hte DsInputData object provided.
     *
     * @param dsInputData The DsInputData instance which contains the attributes needed to
     *                    create an event, namely title, start and end times, and dayIndex.
     */
    @Override
    public void save(CreateEventDsInputData dsInputData) {
        days.get(dsInputData.getDayIndex()).getEvents().put(dsInputData.getTitle(),
                new Event(dsInputData.getTitle(), dsInputData.getStartTime(), dsInputData.getEndTime()));
        // use below once DataAccessEvents are switched to Events.
        // days.get(dsInputData.getDayIndex()).getEvents().put(dsInputData.getTitle(),dsInputData.getNewEvent());
        super.save();
    }
}
