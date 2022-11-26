/**
 * Complete Task DsInput Data Class.
 * Author: Fardin Faruk
 * Modified By: N/A
 * Created: Nov 26, 2022
 * Last Modified: N/A
 */
package complete_task_use_case;
public class CompleteTaskDsInputData {
    private int dayID;
    private String title;

    public CompleteTaskDsInputData(int dayID, String title){
        this.dayID = dayID;
        this.title = title;
    }

    public int getDayID() {
        return dayID;
    }

    public void setDayID(int dayID) {
        this.dayID = dayID;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
