/**
 * Create Task Output Data Class.
 * Author: Fardin Faruk
 * Modified By: Fardin Faruk
 * Created: Nov 19, 2022
 * Last Modified: Nov 27, 2022
 */
package create_task_use_case;

public class CreateTaskOutputData {

    String title;
    boolean isSuccessfullyCreated;
    int dayIndex;
    String errorMessage;


    public CreateTaskOutputData(String title, int dayIndex, String errorMessage){
        this.title = title;
        this.dayIndex = dayIndex;
        this.isSuccessfullyCreated = false;
        this.errorMessage = errorMessage;
    }

    public String getTitle() {
        return title;
    }

    public boolean isSuccessfullyCreated() {
        return isSuccessfullyCreated;
    }

    public void setSuccessfullyCreated(boolean successfullyCreated) {
        isSuccessfullyCreated = successfullyCreated;
    }

    public int getDayIndex() {
        return dayIndex;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
