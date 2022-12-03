package delete_event_use_case;

/**
 *  Contains inputs for DeleteEventInputBoundary's delete method.
 *  @author Khizer Ahmad
 */
public class DeleteEventInputData {

    private int dayIndex;
    private String eventTitle;

    public DeleteEventInputData(int dayIndex, String eventTitle) {
        this.eventTitle = eventTitle;
        this.dayIndex = dayIndex;
    }

    public int getDayIndex() {
        return this.dayIndex;
    }

    public String getEventTitle() {
        return this.eventTitle;
    }
}
