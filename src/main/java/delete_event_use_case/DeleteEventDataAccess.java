/**
 * Delete Event Data Access class.
 * @author : Khizer Ahmad
 * @created: November 19th 2022
 * @since : 2022-11-28, Mon.
 **/

package delete_event_use_case;

import data_access.DataAccessDay;
import data_access.DataAccessEvent;
import data_access.WeekDataAccess;

import java.util.HashMap;
import java.util.ArrayList;

public class DeleteEventDataAccess extends WeekDataAccess implements DeleteEventDsGateway {

    @Override
    public boolean eventExists(int dayIndex, String eventTitle) {
        DataAccessDay day = super.getDays().get(dayIndex);
        return day.getEvents().containsKey(eventTitle);
    }

    @Override
    public void save(DeleteEventOutputData eventData) {
        int dayIndex = eventData.getDayIndex();
        String eventTitle = eventData.getLabel();

        super.getDays().get(dayIndex).getEvents().remove(eventTitle);
        super.save();
    }
}