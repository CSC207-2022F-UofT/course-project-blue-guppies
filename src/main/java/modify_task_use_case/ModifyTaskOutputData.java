/**
 * Task Modification Output Data Class.
 * Author: Raghav Arora
 * Modified By: Raghav Arora
 * Created: Nov 12, 2022
 * Last Modified: Dec 1, 2022
 */
package modify_task_use_case;

public class ModifyTaskOutputData {
    private final String title;
    private final int dayIndex;
    private String errorMessage;
    private boolean isSuccessfullyModified;


    public ModifyTaskOutputData(String title, int dayIndex) {
        this.title = title;
        this.dayIndex = dayIndex;
    }

    String getTitle() { return this.title; }

    int getDayIndex() { return this.dayIndex; }

    String getErrorMessage() { return this.errorMessage; }

    void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }

    boolean getIsSuccessfullyModified() { return this.isSuccessfullyModified; }

    void setSuccessfullyModified(boolean isSuccessfullyCreated) {
        this.isSuccessfullyModified = isSuccessfullyCreated;
    }
}
