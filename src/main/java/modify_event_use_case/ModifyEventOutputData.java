package modify_event_use_case;

import java.time.LocalTime;

public class ModifyEventOutputData {
    private String title;
    private int dayIndex;
    private String newTitle;
    private LocalTime newStartTime;
    private LocalTime newEndTime;
    /**
     *true if the modification was successful, false if not.
     */
    private boolean successfullyModified = true;
    /**
     * if the modification was not successful, represents the reason it failed. Otherwise null.
     */
    private String failureMessage = null;

    public ModifyEventOutputData(String title, int dayIndex, String newTitle, LocalTime newStart, LocalTime newEnd){
        this.title = title;
        this.dayIndex = dayIndex;
        this.newTitle = newTitle;
        this.newStartTime = newStart;
        this.newEndTime = newEnd;
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

    public boolean getSuccessfullyModified(){
        return successfullyModified;
    }

    public void setSuccessfullyModified(boolean successfullyModified) {
        this.successfullyModified = successfullyModified;
    }

    public String getFailureMessage() {
        return failureMessage;
    }

    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }
}
