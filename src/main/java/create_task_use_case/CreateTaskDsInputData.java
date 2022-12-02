/**
 * Create Task DsInputData Class.
 * Author: Fardin Faruk
 * Modified By: Fardin Faruk
 * Created: Nov 19, 2022
 * Last Modified: Nov 27, 2022
 */
package create_task_use_case;

public class CreateTaskDsInputData {
    private String title;
    private int dayIndex;

    public CreateTaskDsInputData(String title, int dayIndex){
        this.title = title;
        this.dayIndex = dayIndex;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public int getDayIndex(){
        return dayIndex;
    }

    public void setDayIndex(int dayIndex) {
        this.dayIndex = dayIndex;
    }
}
