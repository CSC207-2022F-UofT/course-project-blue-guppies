package complete_task_use_case;
/**
 * Task Complete Output Data Class. Instances of this class are returned upon the
 * execution of the application logic for this use case. The errorMessage and
 * isSuccessfullyModified instance attributes, in particular, represent whether the use
 * case logic was successfully executed.
 * @author Fardin Faruk
 */
public class CompleteTaskOutputData {
    String title;
    int dayIndex;
    boolean isSuccessfullyCreated;
    String errorMessage;


    public CompleteTaskOutputData(String title, int dayIndex, String errorMessage){
        this.title = title;
        this.dayIndex = dayIndex;
        this.isSuccessfullyCreated = false;
        this.errorMessage = errorMessage;
    }

    public String getTitle() {
        return title;
    }

    public int getDayIndex() {
        return dayIndex;
    }

    public boolean isSuccessfullyCreated() {
        return isSuccessfullyCreated;
    }

    public void setSuccessfullyCreated(boolean successfullyCreated) {
        isSuccessfullyCreated = successfullyCreated;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
