/**
 * Task Modification Output Data Class.
 * Author: Raghav Arora
 * Modified By: Raghav Arora
 * Created: Nov 12, 2022
 * Last Modified: Nov 19, 2022
 */
package modify_task_use_case;

public class ModifyTaskOutputData {
    private String title;
    private int dayId;

    public ModifyTaskOutputData(String title, int dayId) {
        this.title = title;
        this.dayId = dayId;
    }

    String getTitle() { return this.title; }

    int getDayId() { return this.dayId; }
}
