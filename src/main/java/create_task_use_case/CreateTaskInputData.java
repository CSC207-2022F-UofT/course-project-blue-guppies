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

    public CreateTaskInputData(String title, String dayIndex){
        this.title = title;
        this.dayIndex = 0;
        switch (dayIndex){
            case "Sunday":
                this.dayIndex = 0;
                break;
            case "Monday":
                this.dayIndex = 1;
                break;
            case "Tuesday":
                this.dayIndex = 2;
                break;
            case "Wednesday":
                this.dayIndex = 3;
                break;
            case "Thursday":
                this.dayIndex = 4;
                break;
            case "Friday":
                this.dayIndex = 5;
                break;
            default:
                this.dayIndex = 6;
                break; // if no match assume Saturday
            }
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
