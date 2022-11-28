/**
 * Delete Task OutputData Class.
 * Author: Ricky Fung
 * Modified By: Ricky Fung
 * Created: Nov 19, 2022
 * Last Modified: Nov 28, 2022
 */
package delete_task_use_case;

public class DeleteTaskOutputData {
    private final String taskTitle;
    private final int dayIndex;
    private boolean success = false;

    public DeleteTaskOutputData(int dayIndex, String taskTitle) {
        this.dayIndex = dayIndex;
        this.taskTitle = taskTitle;
    }

    int getDayIndex() {
        return dayIndex;
    }

    String getTaskTitle() {
        return taskTitle;
    }

    public boolean getSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
}
