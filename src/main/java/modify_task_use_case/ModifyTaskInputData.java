/**
 * Task Modification Input Data Class.
 * Author: Raghav Arora
 * Modified By: Raghav Arora
 * Created: Nov 12, 2022
 * Last Modified: Dec 1, 2022
 */
package modify_task_use_case;

public class ModifyTaskInputData {
    private final int dayIndex;
    private final String newTitle;
    private String title;

    public ModifyTaskInputData(int dayIndex, String newTitle, String title) {
        this.dayIndex = dayIndex;
        this.newTitle = newTitle;
        this.title = title;
    }

    public String getNewTitle() { return this.newTitle; }

    public int getDayIndex() { return this.dayIndex; }

    public String getTitle() { return this.title; }

    public void setTitle(String title) { this.title = title; }
}
