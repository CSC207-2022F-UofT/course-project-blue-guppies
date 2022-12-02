/**
 * Complete Task DsInput Data Class.
 * Author: Fardin Faruk
 * Modified By: N/A
 * Created: Nov 26, 2022
 * Last Modified: N/A
 */
package complete_task_use_case;

public class CompleteTaskDsInputData {
    private int dayIndex;
    private String title;

    public CompleteTaskDsInputData(int dayIndex, String title){
        this.dayIndex = dayIndex;
        this.title = title;
    }

    public int getDayIndex() {
        return dayIndex;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
