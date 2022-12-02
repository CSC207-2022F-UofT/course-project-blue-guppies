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
    private int dayIndex;

    public CreateTaskInputData(String title, int dayIndex){
        this.title = title;
        this.dayIndex = dayIndex;
        }


    String getTitle(){
        return title;
    }

    void setTitle(String title){
        this.title = title;
    }

    int getDayIndex(){
        return dayIndex;
    }

}
