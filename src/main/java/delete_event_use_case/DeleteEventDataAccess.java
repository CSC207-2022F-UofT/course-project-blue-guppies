package delete_event_use_case;

import data_access.WeekDataAccess;
import entities.Day;

/**
 * Data Access Class. Interacts with the WeekDataAccess to save the effect of any deletions within data persistence.
 * Implements the eventExists and save methods.
 *
 * @author Khizer Ahmad
 */
public class DeleteEventDataAccess extends WeekDataAccess implements DeleteEventDsGateway {

    /**
     * Checks whether an event titled with title exists in the in-memory week, in the day given by dayIndex.
     *
     * @param dayIndex   the index of the day associated within WeekDataAccess we want to check for an event
     * @param eventTitle the title of the event to look for
     * @return boolean value that signifies whether an event with the given title exists in the day.
     */
    @Override
    public boolean eventExists(int dayIndex, String eventTitle) {
        Day day = days.get(dayIndex);
        return day.getEvents().containsKey(eventTitle);
    }

    /**
     * Mutates day instance attribute of WeekDataAccess by removing event
     * instance attribute of the Day object located at dayIndex.
     * Calls save() to save the deletion to a .ser file, for data persistence
     *
     * @param eventData specifies the day index and title of event to be removed
     */
    @Override
    public void save(DeleteEventOutputData eventData) {
        int dayIndex = eventData.getDayIndex();
        String eventTitle = eventData.getLabel();

        days.get(dayIndex).getEvents().remove(eventTitle);
        super.save();
    }
}