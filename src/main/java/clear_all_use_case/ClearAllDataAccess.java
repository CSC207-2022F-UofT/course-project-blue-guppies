package clear_all_use_case;

import entities.Day;
import data_access.WeekDataAccess;

/**
 * Implements the save method in ClearAllDsGateway. Save method mutates day instance
 * attribute of WeekDataAccess by removing the Tasks and Events of all days.
 * @author Ricky Fung
 */
public class ClearAllDataAccess extends WeekDataAccess implements ClearAllDsGateway {

    /**
     * Mutates the day instance attribute of the parent class WeekDataAccess by removing
     * the Task and Event instance attributes of the Day object located each dayIndex. This then invokes
     * the save method of the parent class to save changes to serializable file.
     */
    @Override
    public void save() {
        for(Day day : days){
            day.getEvents().clear();
            day.getTasks().clear();
        }
        super.save();
    }
}
