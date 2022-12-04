package modify_event_use_case;

import java.time.LocalTime;

/**
 * Input for the DsGateway save method, specifying the parameters of the event to be modified in the database.
 * @author Daniel Livshits
 */
public class ModifyEventDsInputData {
    private final int dayIndex;
    private final String title;
    private final String newTitle;
    private final LocalTime newStartTime;
    private final LocalTime newEndTime;

    /**
     * @param title - The current title of the event to be modified.
     * @param dayIndex - The index for the day of the event being modified.
     * @param newTitle - The new desired title for the event.
     * @param newStart - The new desired starting time.
     * @param newEnd - The new desired ending time.
     */
    public ModifyEventDsInputData(int dayIndex, String title, String newTitle, LocalTime newStart, LocalTime newEnd){
        this.dayIndex = dayIndex;
        this.title = title;
        this.newTitle = newTitle;
        this.newStartTime = newStart;
        this.newEndTime = newEnd;
    }

    public int getDayIndex() {
        return dayIndex;
    }

    public String getTitle() {
        return title;
    }

    public String getNewTitle() {
        return newTitle;
    }

    public LocalTime getNewStartTime() {
        return newStartTime;
    }

    public LocalTime getNewEndTime() {
        return newEndTime;
    }
}
