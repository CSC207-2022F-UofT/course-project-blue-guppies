package delete_task_use_case;

/**
 * Contains inputs for save method in DeleteTaskDataAccess.
 * @author Ricky Fung
 */
public class DeleteTaskDsInputData {
    private final int dayIndex;
    private final String taskTitle;

    public DeleteTaskDsInputData(int dayIndex, String taskTitle) {
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
