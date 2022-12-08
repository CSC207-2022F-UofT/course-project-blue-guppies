package modify_event_use_case;

import java.time.LocalTime;

/**
 * Output data to be sent back through to the Controller. Contains information on the task to be modified,
 * as well as whether that modification was successful, and, if not, why the modification failed.
 *
 * @author Daniel Livshits
 */
public class ModifyEventOutputData {
    private final String title;
    private final int dayIndex;
    private final String newTitle;
    private final LocalTime newStartTime;
    private final LocalTime newEndTime;
    /**
     * true if the modification was successful, false if not.
     */
    private boolean successfullyModified = true;
    /**
     * if the modification was not successful, represents the reason it failed. Otherwise null.
     */
    private String failureMessage = null;

    /**
     * @param title    - The current title of the event to be modified.
     * @param dayIndex - The index for the day of the event being modified.
     * @param newTitle - The new desired title for the event.
     * @param newStart - The new desired starting time.
     * @param newEnd   - The new desired ending time.
     */
    public ModifyEventOutputData(String title, int dayIndex, String newTitle, LocalTime newStart, LocalTime newEnd) {
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

    public boolean getSuccessfullyModified() {
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
