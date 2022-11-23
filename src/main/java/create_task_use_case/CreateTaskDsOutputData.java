/**
 * Create Task DsInputData Class.
 * Author: Fardin Faruk
 * Modified By: N/A
 * Created: Nov 19, 2022
 * Last Modified: N/A
 */
package create_task_use_case;

public class CreateTaskDsOutputData {
    private String title;
    private boolean completed;
    private int dayID;

    public CreateTaskDsOutputData(String title, boolean completed, int dayID){
        this.title = title;
        this.completed = completed;
        this.dayID = dayID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public boolean getCompleted(){
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getDayID(){
        return dayID;
    }

    public void setDayID(int dayID) {
        this.dayID = dayID;
    }
}
