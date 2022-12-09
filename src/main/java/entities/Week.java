package entities;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Week class for use in data access. We'll only use one of these at a time in our current implementation.
 *
 * @author Daniel Livshits
 */
public class Week implements Serializable {
    private final ArrayList<Day> days;

    /**
     * @param days the list of days that this week contains.
     *             Precondition: days.size() == 7
     *             Note the precondition could be enforced with an array but an arraylist is necessary here.
     */
    public Week(ArrayList<Day> days) {
        this.days = days;
    }

    public ArrayList<Day> getDays() {
        return days;
    }
}