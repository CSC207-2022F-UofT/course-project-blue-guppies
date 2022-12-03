package delete_task_use_case;

/**
 * Contains inputs for InputBoundary's deleteTask method.
 * @author Ricky Fung
 */
public class DeleteTaskInputData {

    private final int dayIndex;
    private final String taskTitle;

    public DeleteTaskInputData(int dayIndex, String taskTitle) {
        this.taskTitle = taskTitle;
        this.dayIndex = dayIndex;
    }

    int getDayIndex() {
        return this.dayIndex;
    }

    String getTaskTitle() {
        return this.taskTitle;
    }
}
