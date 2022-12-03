package modify_task_use_case;

/**
 * Task Modification Output Data Class. Instances of this class are returned upon the
 * execution of the application logic for this use case. The errorMessage and
 * isSuccessfullyModified instance attributes, in particular, represent whether the use
 * case logic was successfully executed.
 * @author Raghav Arora
 */
public class ModifyTaskOutputData {
    private final String title;
    private final int dayIndex;
    private String errorMessage;
    private boolean isSuccessfullyModified;


    public ModifyTaskOutputData(String title, int dayIndex) {
        this.title = title;
        this.dayIndex = dayIndex;
    }

    String getTitle() { return this.title; }

    int getDayIndex() { return this.dayIndex; }

    String getErrorMessage() { return this.errorMessage; }

    void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }

    boolean getIsSuccessfullyModified() { return this.isSuccessfullyModified; }

    void setSuccessfullyModified(boolean isSuccessfullyModified) {
        this.isSuccessfullyModified = isSuccessfullyModified;
    }
}
