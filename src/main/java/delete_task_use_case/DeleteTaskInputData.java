/**
 * Delete Task InputData Class.
 * Author: Ricky Fung
 * Modified By: Ricky Fung
 * Created: Nov 19, 2022
 * Last Modified: Nov 28, 2022
 */
package delete_task_use_case;

public class DeleteTaskInputData {

    private final int dayIndex;
    private final String taskTitle;

    public DeleteTaskInputData(int dayIndex, String taskTitle) {
        this.taskTitle = taskTitle;
        this.dayIndex = dayIndex;
    }

    public int getDayIndex() {
        return this.dayIndex;
    }

    public String getTaskTitle() {
        return this.taskTitle;
    }
}
