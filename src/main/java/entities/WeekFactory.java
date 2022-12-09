package entities;

import java.util.ArrayList;

/**
 * WeekFactory creates a new Week object.
 *
 * @author Daniel Livshits
 */
public class WeekFactory {

    /**
     * @param days the list of days this week should be initialized with. Should always be of length 7.
     * @return the week containing the information from days
     */
    public Week createWeek(ArrayList<Day> days) {
        return new Week(days);
    }
}
