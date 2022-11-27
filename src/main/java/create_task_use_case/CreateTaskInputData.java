/**
 * Create Task Input Data Class.
 * Author: Fardin Faruk
 * Modified By: Fardin Faruk
 * Created: Nov 19, 2022
 * Last Modified: Nov 27, 2022
 */
package create_task_use_case;

public class CreateTaskInputData {

    private String title;
    private boolean completed;
    private int dayIndex;

    public CreateTaskInputData(String title, boolean completed, int dayIndex){
        this.title = title;
        this.completed = completed;
        this.dayIndex = dayIndex;
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

    int getDayIndex(){
        return dayIndex;
    }

}
