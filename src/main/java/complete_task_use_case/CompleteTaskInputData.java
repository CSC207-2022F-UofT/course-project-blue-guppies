/**
 * Complete Task Input Data Class.
 * Author: Fardin Faruk
 * Modified By: N/A
 * Created: Nov 26, 2022
 * Last Modified: N/A
 */
package complete_task_use_case;

public class CompleteTaskInputData {
    private int dayIndex;
    private String title;

    public CompleteTaskInputData(String dayIndex, String title){
        this.title = title;
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

    public int getDayIndex() {
        return dayIndex;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
