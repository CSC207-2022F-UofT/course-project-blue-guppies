/**
 * Task Modification DsInputData Class.
 * Author: Raghav Arora
 * Modified By: Raghav Arora
 * Created: Nov 12, 2022
 * Last Modified: Nov 19, 2022
 */
package modify_task_use_case;

public class ModifyTaskDsInputData {
    private int dayID;
    private String newTitle;
    private String title;

    public ModifyTaskDsInputData(int dayId, String newTitle, String title) {
        this.dayID = dayId;
        this.newTitle = newTitle;
        this.title = title;
    }

    public String getNewTitle() { return this.newTitle; }

    public int getDayID() { return this.dayID; }

    public String getTitle() { return this.title; }

    public void setTitle(String title) { this.title = title; }
}