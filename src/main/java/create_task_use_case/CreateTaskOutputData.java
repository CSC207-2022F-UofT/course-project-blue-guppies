/**
 * Create Task Output Data Class.
 * Author: Fardin Faruk
 * Modified By: N/A
 * Created: Nov 19, 2022
 * Last Modified: N/A
 */
package create_task_use_case;

public class CreateTaskOutputData {

    String title;
    boolean completed;
    boolean isSuccessfullyCreated;
    int dayID;


    public CreateTaskOutputData(String title, boolean completed, int dayID){
        this.title = title;
        this.completed = completed;
        this.dayID = dayID;
        this.isSuccessfullyCreated = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isSuccessfullyCreated() {
        return isSuccessfullyCreated;
    }

    public void setSuccessfullyCreated(boolean successfullyCreated) {
        isSuccessfullyCreated = successfullyCreated;
    }

    public int getDayID() {
        return dayID;
    }

    public void setDayID(int dayID) {
        this.dayID = dayID;
    }
}
