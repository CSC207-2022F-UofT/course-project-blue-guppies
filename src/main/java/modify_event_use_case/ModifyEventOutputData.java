/**
 * Output data to be sent back through to the Controller.
 * Author: Daniel Livshits
 * Created: Nov 19, 2022
 * Modified by:
 * Last Modified: Nov 19, 2022
 */
package modify_event_use_case;

import java.time.LocalTime;

public class ModifyEventOutputData {
    private final String title;
    private final int dayIndex;
    private final String newTitle;
    private final LocalTime newStartTime;
    private final LocalTime newEndTime;
    /**
     *true if the modification was successful, false if not.
     */
    private boolean successState = true;
    /**
     * if the modification was not successful, represents the reason it failed. Otherwise null.
     */
    private String failureType = null;

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

    public boolean getSuccessState(){
        return successState;
    }

    public void setSuccessState(boolean successState) {
        this.successState = successState;
    }

    public String getFailureType() {
        return failureType;
    }

    public void setFailureType(String failureType) {
        this.failureType = failureType;
    }
}
