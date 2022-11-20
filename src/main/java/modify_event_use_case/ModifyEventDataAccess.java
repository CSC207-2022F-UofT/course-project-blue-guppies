/**
 * Data Access Class. Interacts with the in-memory week to "save" modifications.
 * Author: Daniel Livshits
 * Created: Nov 19, 2022
 * Modified by:
 * Last Modified: Nov 19, 2022
 */
package modify_event_use_case;

import data_access.WeekDataAccess;
import data_access.DataAccessEvent;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Objects;

public class ModifyEventDataAccess extends WeekDataAccess implements ModifyEventDsGateway{
    @Override
    public void save(ModifyEventDsInputData dataAccessInput){
        HashMap<String, DataAccessEvent> eventsToChange = days.get(dataAccessInput.getDayIndex()).getEvents();
        DataAccessEvent eventToChange = eventsToChange.get(dataAccessInput.getTitle());
        DataAccessEvent newEvent = new DataAccessEvent(dataAccessInput.getNewTitle(), dataAccessInput.getNewStartTime(),
                dataAccessInput.getNewEndTime());
        eventsToChange.remove(eventToChange.getTitle());
        eventsToChange.put(dataAccessInput.getNewTitle(), newEvent);
        super.save();
    }

    @Override
    public boolean titleExistsInDay(int dayIndex, String title) {
        return days.get(dayIndex).getEvents().containsKey(title);
    }

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
