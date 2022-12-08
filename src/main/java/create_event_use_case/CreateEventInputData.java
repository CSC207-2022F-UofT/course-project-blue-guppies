package create_event_use_case;

/**
 * Input Data class for the Create Event use case. An instance of this class is initialized
 * in the Controller class before the input boundary's implementation of create() is called with
 * the instance as a parameter.
 *
 * @author Anna Myllyniemi, Fardin Faruk
 */
public class CreateEventInputData {
    private final String title;
    private final String startTime;
    private final String endTime;
    private final int dayIndex;

    public CreateEventInputData(String title, String startTime, String endTime, int dayIndex) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.dayIndex = dayIndex;
    }

    public String getTitle() {
        return title;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public int getDayIndex() {
        return dayIndex;
    }
}
