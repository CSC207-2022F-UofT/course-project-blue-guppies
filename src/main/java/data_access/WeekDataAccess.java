/**
 * The superclass for data access, with an static attribute and private method to be shared across all create_event_use_case.CreateEventPresenter.data_access.DataAccess
 * classes.
 * Author: Daniel Livshits
 * Modified by: Daniel Livshits
 * Created: Nov 14, 2022
 * Last Modified: Nov 19, 2022
 */
package data_access;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class WeekDataAccess implements Serializable {

    /**
     * The ArrayList of days to be used for data persistence. The state of this data structure is saved
     * to a .ser file.
     */
    protected static ArrayList<DataAccessDay> days = new ArrayList<>();


    /**
     * Initializes days to a week with 7 empty days if it hasn't already been initialized.
     */
    public WeekDataAccess() {
        if(days.isEmpty()){
            DataAccessDay emptyDay = new DataAccessDay(new HashMap<>(), new HashMap<>());
            for(int i = 0; i < 7; i++){
                days.add(emptyDay);
            }
        }
    }

    /**
     * Sets days to the week specified by dataDays
     * Precondition: dataDays is an ArrayList containing 7 dataDay instances
     * @param dataDays - a representation of a week.
     */
    public WeekDataAccess(ArrayList<DataAccessDay> dataDays){
        days = dataDays;
    }

    public ArrayList<DataAccessDay> getDays() {
        return days;
    }

    public static void setDays(ArrayList<DataAccessDay> days) {
        WeekDataAccess.days = days;
    }

    protected void save(){
        // TODO: Implement using Serializable once we understand the implementation.
    }
}
