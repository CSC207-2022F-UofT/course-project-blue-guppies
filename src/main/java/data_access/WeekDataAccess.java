package data_access;

import entities.Day;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * The superclass for data access, with a static attribute and private method to be shared across all create_event_use_case.CreateEventPresenter.data_access.DataAccess
 * classes.
 * @author Daniel Livshits
 */
public class WeekDataAccess implements Serializable {

    /**
     * The ArrayList of days to be used for data persistence. The state of this data structure is saved
     * to a .ser file.
     */
    protected static ArrayList<Day> days = new ArrayList<>();


    /**
     * Initializes days to a week with 7 empty days if it hasn't already been initialized.
     */
    public WeekDataAccess() {
        if(days.isEmpty()){
            for(int i = 0; i < 7; i++){
                Day emptyDay = new Day(new HashMap<>(), new HashMap<>());
                days.add(emptyDay);
            }
        }
    }

    /**
     * Sets days to the week specified by dataDays
     * Precondition: dataDays is an ArrayList containing 7 dataDay instances
     * @param dataDays - a representation of a week.
     */
    public WeekDataAccess(ArrayList<Day> dataDays){
        days = dataDays;
    }

    public ArrayList<Day> getDays() {
        return days;
    }

    public static void setDays(ArrayList<Day> days) {
        WeekDataAccess.days = days;
    }

    protected void save(){
    }
}
