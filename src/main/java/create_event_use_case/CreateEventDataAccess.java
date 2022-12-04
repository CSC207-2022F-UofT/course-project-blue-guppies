package create_event_use_case;

import data_access.DataAccessEvent;
import data_access.WeekDataAccess;

import java.time.LocalTime;
import java.util.HashMap;

public class CreateEventDataAccess extends WeekDataAccess implements CreateEventDsGateway {
    @Override
    public boolean eventExistsByTitle(String title, int dayIndex) {
        return days.get(dayIndex).getEvents().containsKey(title);
    }

    @Override
    public boolean isTimeConflict(int dayIndex, String title, LocalTime startTime, LocalTime endTime) {
        HashMap<String, DataAccessEvent> eventsToCheck = days.get(dayIndex).getEvents();
        for(String existingEventTitle: eventsToCheck.keySet()){
            LocalTime start = eventsToCheck.get(existingEventTitle).getStartTime();
            LocalTime end = eventsToCheck.get(existingEventTitle).getEndTime();
            if(!(startTime.isAfter(end) || endTime.isBefore(start))){
                return true;
            }
        }
        return false;
    }

    @Override
    public void save(CreateEventDsInputData dsInputData) {
        days.get(dsInputData.getDayIndex()).getEvents().put(dsInputData.getTitle(),
                new DataAccessEvent(dsInputData.getTitle(), dsInputData.getStartTime(), dsInputData.getEndTime()));
        // use below once DataAccessEvents are switched to Events.
        // days.get(dsInputData.getDayIndex()).getEvents().put(dsInputData.getNewEvent().getTitle(),dsInputData.getNewEvent());
        super.save();
    }
}
