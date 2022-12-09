package delete_task_use_case;

/**
 * Contains inputs for save method in DeleteTaskDataAccess.
 *
 * @author Ricky Fung
 */
public class DeleteTaskDsInputData {
    private final int dayIndex;
    private final String taskTitle;

    DeleteTaskDsInputData(int dayIndex, String taskTitle) {
        this.taskTitle = taskTitle;
        this.dayIndex = dayIndex;
    }

    protected int getDayIndex() {
        return this.dayIndex;
    }

    protected String getTaskTitle() {
        return this.taskTitle;
    }
}
