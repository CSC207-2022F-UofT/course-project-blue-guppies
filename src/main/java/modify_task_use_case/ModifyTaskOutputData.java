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
    private int dayIndex;
    private boolean isSuccessfullyModified;
    private String errorMessage = "";

    public ModifyTaskOutputData(String title, int dayIndex, boolean isSuccessfullyModified, String errorMessage) {
        this.title = title;
        this.dayIndex = dayIndex;
        this.isSuccessfullyModified = isSuccessfullyModified;
        this.errorMessage = errorMessage;
    }

    public String getTitle() { return this.title; }

    public int getDayIndex() { return this.dayIndex; }

    public boolean isSuccessfullyModified() {
        return isSuccessfullyModified;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
