package delete_task_use_case;

/**
 * Instances of this class are returned and set back to
 * the controller, with the errorMessage and success instance
 * attributes indicating whether deletion conditions are met.
 *
 * @author Ricky Fung
 */
public class DeleteTaskOutputData {
    private final String taskTitle;
    private final int dayIndex;
    private boolean success;
    private String errorMessage;

    public DeleteTaskOutputData(int dayIndex, String taskTitle) {
        this.dayIndex = dayIndex;
        this.taskTitle = taskTitle;
    }

    public int getDayIndex() {
        return dayIndex;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
