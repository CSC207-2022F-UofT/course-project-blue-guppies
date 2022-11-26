/**
 * Input for the DsGateway save method.
 * Author: Daniel Livshits
 * Created: Nov 19, 2022
 * Modified by:
 * Last Modified: Nov 19, 2022
 */
package modify_event_use_case;

import java.time.LocalTime;

public class ModifyEventDsInputData {
    private int dayIndex;
    private String title;
    private String newTitle;
    private LocalTime newStartTime;
    private LocalTime newEndTime;

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
