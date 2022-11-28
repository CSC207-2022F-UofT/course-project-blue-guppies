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


    public CompleteTaskOutputData(String title, int dayIndex){
        this.title = title;
        this.dayIndex = dayIndex;
        this.isSuccessfullyCreated = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
