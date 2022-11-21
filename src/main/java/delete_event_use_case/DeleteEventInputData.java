package delete_event_use_case;

/**
 * Delete Event Input Data class.
 * @author : Khizer Ahmad
 * @created: November 19th 2022
 * @since : 2022-11-21, Mon.
 **/
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
