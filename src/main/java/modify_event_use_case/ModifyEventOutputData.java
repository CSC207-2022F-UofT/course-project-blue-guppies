package modify_event_use_case;

import java.time.LocalTime;

public class ModifyEventOutputData {
    private final String title;
    private final int day;
    private final String newTitle;
    private final LocalTime newStartTime;
    private final LocalTime newEndTime;
    private final boolean successState;
    private final String failureType = null;

    public ModifyEventOutputData(String title, int day, String newTitle, LocalTime newStart, LocalTime newEnd, boolean successState){
        this.title = title;
        this.day = day;
        this.newTitle = newTitle;
        this.newStartTime = newStart;
        this.newEndTime = newEnd;
        this.successState = successState;
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

    public boolean getSuccessState(){
        return successState;
    }
}
