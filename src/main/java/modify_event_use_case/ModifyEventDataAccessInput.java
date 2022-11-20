package modify_event_use_case;

import java.time.LocalTime;

public class ModifyEventDataAccessInput {
    private final int dayIndex;
    private final String title;
    private final String newTitle;
    private final LocalTime newStartTime;
    private final LocalTime newEndTime;

    public ModifyEventDataAccessInput(int dayIndex, String title, String newTitle, LocalTime newStart, LocalTime newEnd){
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
