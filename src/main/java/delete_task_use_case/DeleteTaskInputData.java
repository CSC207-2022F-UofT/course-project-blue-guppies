package delete_task_use_case;

/**
 * Contains inputs for InputBoundary's deleteTask method.
 * @author Ricky Fung
 */
public class DeleteTaskInputData {

    private final int dayIndex;
    private final String taskTitle;

    DeleteTaskInputData(int dayIndex, String taskTitle) {
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
