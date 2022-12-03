package create_task_use_case;

/**
 * Task Creation Output Data Class. Instances of this class are returned upon the
 * execution of the application logic for this use case. The errorMessage and
 * isSuccessfullyModified instance attributes, in particular, represent whether the use
 * case logic was successfully executed.
 * @author Fardin Faruk
 */
public class CreateTaskOutputData {

    private final String title;
    protected boolean isSuccessfullyCreated;
    private final int dayIndex;
    private String errorMessage;


    public CreateTaskOutputData(String title, int dayIndex, String errorMessage){
        this.title = title;
        this.dayIndex = dayIndex;
        this.isSuccessfullyCreated = false;
        this.errorMessage = errorMessage;
    }

    public String getTitle() {
        return title;
    }

    public boolean isSuccessfullyCreated() {
        return isSuccessfullyCreated;
    }

    public void setSuccessfullyCreated(boolean successfullyCreated) {
        isSuccessfullyCreated = successfullyCreated;
    }

    public int getDayIndex() {
        return dayIndex;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
