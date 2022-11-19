package modify_event_use_case;

import java.time.LocalTime;

public class ModifyEventInputData {
    private final String title;
    private final int day;
    private final String newTitle;
    private final LocalTime newStartTime;
    private final LocalTime newEndTime;

    public ModifyEventInputData(String title, int day, String newTitle, LocalTime newStartTime, LocalTime newEndTime){
        this.title = title;
        this.day = day;
        this.newTitle = newTitle;
        this.newStartTime = newStartTime;
        this.newEndTime = newEndTime;
    }

    public String getTitle() {
        return title;
    }

    public int getDay() {
        return day;
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
