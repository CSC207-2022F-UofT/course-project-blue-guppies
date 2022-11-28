/**
 * Input for the InputBoundary's modify method.
 * Author: Daniel Livshits
 * Created: Nov 19, 2022
 * Modified by:
 * Last Modified: Nov 19, 2022
 */
package modify_event_use_case;

public class ModifyEventInputData {
    private final String title;
    private final int dayIndex;
    private final String newTitle;
    private final String newStartTime;
    private final String newEndTime;

    /**
     * @param title - the current title of the event to be modified
     * @param dayIndex - the index for the day of the event being modified
     * @param newTitle - the new desired title for the event
     * @param newStartTime - the new desired starting time
     * @param newEndTime - the new desired ending time
     */
    public ModifyEventInputData(String title, int dayIndex, String newTitle, String newStartTime, String newEndTime){
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

    public String getNewStartTime() {
        return newStartTime;
    }

    public String getNewEndTime() {
        return newEndTime;
    }
}
