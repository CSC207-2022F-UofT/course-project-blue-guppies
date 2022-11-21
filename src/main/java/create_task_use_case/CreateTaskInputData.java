/**
 * Create Task Input Data Class.
 * Author: Fardin Faruk
 * Modified By: N/A
 * Created: Nov 19, 2022
 * Last Modified: N/A
 */
package create_task_use_case;

public class CreateTaskInputData {

    private String title;
    private boolean completed;
    private int dayID;

    public CreateTaskInputData(String title, boolean completed, int dayID){
        this.title = title;
        this.completed = completed;
        this.dayID = dayID;
        }


    String getTitle(){
        return title;
    }

    void setTitle(String title){
        this.title = title;
    }

    boolean getCompleted(){
        return completed;
    }

    void setCompleted(boolean completed){
        this.completed = completed;
    }

    int getDayID(){
        return dayID;
    }

    void setDayID(int dayID){
        this.dayID = dayID;
    }

}
