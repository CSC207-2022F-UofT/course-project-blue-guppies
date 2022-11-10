/**
 * Week Class. This may not be used (aside from an equivalent class for serialization) in the current specification,
 * but would be helpful if we extended the project to support multiple weeks instead of just one.
 * Author: Daniel Livshits
 * Created: Nov 9, 2022
 * Last Modified: Nov 9, 2022
 */
package entities;

import java.util.ArrayList;
import java.util.HashMap;

public class Week {
    private final ArrayList<Day> days;

    public Week() {
        Day d = new Day(new HashMap<>(), new HashMap<>());
        days = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            days.add(d);
        }
    }

    public Week(ArrayList<Day> days) {
        this.days = days;
    }

    public ArrayList<Day> getDays() {
        return days;
    }
}