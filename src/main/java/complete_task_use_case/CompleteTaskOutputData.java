/**
 * Complete Task Output Data Class.
 * Author: Fardin Faruk
 * Modified By: N/A
 * Created: Nov 26, 2022
 * Last Modified: N/A
 */
package complete_task_use_case;

public class CompleteTaskOutputData {
    String title;
    int dayIndex;
    boolean isSuccessfullyCreated;
    String errorMessage;


    public CompleteTaskOutputData(String title, int dayIndex, String errorMessage){
        this.title = title;
        this.dayIndex = dayIndex;
        this.isSuccessfullyCreated = false;
        this.errorMessage = errorMessage;
    }

    public String getTitle() {
        return title;
    }

    public int getDayIndex() {
        return dayIndex;
    }

    public boolean isSuccessfullyCreated() {
        return isSuccessfullyCreated;
    }

    public void setSuccessfullyCreated(boolean successfullyCreated) {
        isSuccessfullyCreated = successfullyCreated;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
