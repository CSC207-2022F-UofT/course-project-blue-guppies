/**
 * Task Modification DsInputData Class.
 * Author: Raghav Arora
 * Modified By: Raghav Arora
 * Created: Nov 12, 2022
 * Last Modified: Dec 1, 2022
 */
package modify_task_use_case;

public class ModifyTaskDsInputData {
    private final int dayIndex;
    private final String newTitle;
    private String title;

    public ModifyTaskDsInputData(int dayIndex, String newTitle, String title) {
        this.dayIndex = dayIndex;
        this.newTitle = newTitle;
        this.title = title;
    }

    public String getNewTitle() { return this.newTitle; }

    public int getDayIndex() { return this.dayIndex; }

    public String getTitle() { return this.title; }

    public void setTitle(String title) { this.title = title; }
}
