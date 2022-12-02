package modify_task_use_case;

/** Task Modification DsInputData Class. Instances of type ModifyTaskDsInputData are
 * passed on to the gateway to execute the use case's application logic.
 * Author: Raghav Arora
 * Modified By: Raghav Arora
 * Created: Nov 12, 2022
 * Last Modified: Dec 2, 2022
 */
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
