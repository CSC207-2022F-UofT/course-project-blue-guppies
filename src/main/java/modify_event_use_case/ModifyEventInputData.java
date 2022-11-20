package modify_event_use_case;

import java.time.LocalTime;

public class ModifyEventInputData {
    private final String title;
    private final int dayIndex;
    private final String newTitle;
    private final LocalTime newStartTime;
    private final LocalTime newEndTime;

    public ModifyEventInputData(String title, int dayIndex, String newTitle, LocalTime newStartTime, LocalTime newEndTime){
        this.title = title;
        this.dayIndex = dayIndex;
        this.newTitle = newTitle;
        this.newStartTime = newStartTime;
        this.newEndTime = newEndTime;
    }

    public String getTitle() {
        return title;
    }

    public int getDayIndex() {
        return dayIndex;
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
