package strategies;

public class SaturdayAssumingConverter implements DayToIndexConverter{

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
