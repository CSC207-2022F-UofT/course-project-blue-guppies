/**
 * Task Modification Output Data Class.
 * Author: Raghav Arora
 * Modified By: Raghav Arora
 * Created: Nov 12, 2022
 * Last Modified: Nov 26, 2022
 */
package modify_task_use_case;

public class ModifyTaskOutputData {
    private String title;
    private int dayID;

    public ModifyTaskOutputData(String title, int dayID) {
        this.title = title;
        this.dayID = dayID;
    }

    String getTitle() { return this.title; }

    int getDayID() { return this.dayID; }
}
