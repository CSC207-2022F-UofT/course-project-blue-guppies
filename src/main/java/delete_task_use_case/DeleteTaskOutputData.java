package delete_task_use_case;

/**
 * Instances of this class are returned and set back to
 * the controller, with the errorMessage and success instance
 * attributes indicating whether deletion conditions are met.
 * @author Ricky Fung
 */
public class DeleteTaskOutputData {
    String taskTitle;
    int dayIndex;
    boolean success;
    String errorMessage;

    public DeleteTaskOutputData(int dayIndex, String taskTitle) {
        this.dayIndex = dayIndex;
        this.taskTitle = taskTitle;
        this.success = false;
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
