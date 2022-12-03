package modify_event_use_case;

import data_access.WeekDataAccess;
import data_access.DataAccessEvent;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Objects;

/**
 * Data Access Class. Interacts with the in-memory week to "save" modifications.
 * @author Daniel Livshits
 */
public class ModifyEventDataAccess extends WeekDataAccess implements ModifyEventDsGateway{
    /**
     * Saves the modification specified in the dsInputData to an in-memory version of the week and a .ser file.
     *
     * @param dsInputData Specifies the current and desired new parameters of the task being changed.
     */
    @Override
    public void save(ModifyEventDsInputData dsInputData){
        HashMap<String, DataAccessEvent> eventsToChange = days.get(dsInputData.getDayIndex()).getEvents();
        DataAccessEvent eventToChange = eventsToChange.get(dsInputData.getTitle());
        eventsToChange.remove(eventToChange.getTitle());
        eventToChange.setTitle(dsInputData.getNewTitle());
        eventToChange.setStartTime(dsInputData.getNewStartTime());
        eventToChange.setEndTime(dsInputData.getNewEndTime());
        eventsToChange.put(dsInputData.getNewTitle(), eventToChange);
        super.save();
    }

    /**
     * Checks whether an event titled with title exists in the in-memory week, in the day given by dayIndex.
     *
     * @param dayIndex The index of the day we want to check for an event.
     * @param title The title that we want to look for.
     * @return Whether an event titled with title exists in the given day.
     */
    @Override
    public boolean titleExistsInDay(int dayIndex, String title) {
        return days.get(dayIndex).getEvents().containsKey(title);
    }

    /**
     * Checks the given day to see if the new desired start and end times conflict with the timing of any event,
     * other than the event titled with title (which we want to modify the times for).
     *
     * @param dayIndex The index of the day to be checked.
     * @param title The title of the event we are trying to modify.
     * @param newStart The new desired start time of the event.
     * @param newEnd The new desired end time of the event.
     * @return Whether the new desired start and end times for the event conflict with another event in the day.
     */
    @Override
    public boolean isTimeConflict(int dayIndex, String title, LocalTime newStart, LocalTime newEnd) {
        HashMap<String, DataAccessEvent> eventsToCheck = days.get(dayIndex).getEvents();
        for(String name: eventsToCheck.keySet()){
            if(!Objects.equals(name, title)){
                LocalTime start = eventsToCheck.get(name).getStartTime();
                LocalTime end = eventsToCheck.get(name).getEndTime();
                if(!(newStart.isAfter(end) || newEnd.isBefore(start))){
                    return true;
                }
            }
        }
        return false;
    }
}
