/**
 * Task Modification Input Data Class.
 * Author: Raghav Arora
 * Modified By: Raghav Arora
 * Created: Nov 12, 2022
 * Last Modified: Nov 26, 2022
 */
package modify_task_use_case;

public class ModifyTaskInputData {
    private int dayID;
    private String newTitle;
    private String title;

    public ModifyTaskInputData(int dayID, String newTitle, String title) {
        this.dayID = dayID;
        this.newTitle = newTitle;
        this.title = title;
    }

    public String getNewTitle() { return this.newTitle; }

    public int getDayID() { return this.dayID; }

    public String getTitle() { return this.title; }

    public void setTitle(String title) { this.title = title; }
}
