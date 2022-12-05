package complete_task_use_case;
/**
 * Task Complete Output Data Class. Instances of this class are returned upon the
 * execution of the application logic for this use case. The errorMessage and
 * isSuccessfullyModified instance attributes, in particular, reports whether the use
 * case logic was successfully executed.
 * @author Fardin Faruk
 */
public class CompleteTaskOutputData {
    private final String title;
    private final int dayIndex;
    private boolean successfullyCompleted;
    private String errorMessage;
    private boolean taskCompleted;


    public CompleteTaskOutputData(String title, int dayIndex, boolean taskCompleted){
        this.title = title;
        this.dayIndex = dayIndex;
        this.successfullyCompleted = false;
        this.errorMessage = "";
        this.taskCompleted = taskCompleted;
    }

    public String getTitle() {
        return title;
    }

    public int getDayIndex() {
        return dayIndex;
    }

    public boolean isSuccessfullyCompleted() {
        return successfullyCompleted;
    }

    public void setSuccessfullyCreated(boolean successfullyComplete) {
        this.successfullyCompleted = successfullyComplete;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isTaskCompleted() {
        return taskCompleted;
    }

    public void setTaskCompleted(boolean completed) {
        this.taskCompleted = completed;
    }
}
