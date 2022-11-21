package delete_event_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessEvent;
import data_access.WeekDataAccess;

import java.util.HashMap;
import java.util.ArrayList;

/**
 * Delete Event Data Access class.
 * @author : Khizer Ahmad
 * @created: November 19th 2022
 * @since : 2022-11-21, Mon.
 **/
public class DeleteEventDataAccess extends WeekDataAccess implements DeleteEventDsGateway {

    @Override
    public boolean eventExists(int dayIndex, String eventTitle) {
        DataAccessDay day = super.getDays().get(dayIndex);
        return day.getEvents().containsKey(eventTitle);
        //this should always return true if event is stored correctly
    }

    @Override
    public void save(DeleteEventOutputData eventData) {
        int dayIndex = eventData.getDayIndex();
        String eventTitle = eventData.getLabel();

        super.getDays().get(dayIndex).getEvents().remove(eventTitle);
        super.save();
    }
}