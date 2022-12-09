package strategies;

/**
 * A DayToIndexConverter that converts the name of a day (capitalized) into an index corresponding to that day
 * (specifically the way these days would be organized in a List assuming a week starts on Sunday).
 * @author Daniel Livshits
 */
public class SaturdayAssumingConverter implements DayToIndexConverter{

    /**
     * Converts the name of a day into the index for that day in a List sorted in the order of a Sunday-Saturday week.
     * @param dayName the name of the day
     * @return the index corresponding to dayName
     */
    public int convertDayNameToIndex(String dayName){
        switch (dayName) {
            case "Sunday":
                return 0;
            case "Monday":
                return 1;
            case "Tuesday":
                return 2;
            case "Wednesday":
                return 3;
            case "Thursday":
                return 4;
            case "Friday":
                return 5;
            default:
                return 6;
            // if no match assume Saturday
        }
    }
}
