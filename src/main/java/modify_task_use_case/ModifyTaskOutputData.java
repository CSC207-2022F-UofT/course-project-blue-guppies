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

    public String getTitle() { return this.title; }

    public int getDayIndex() { return this.dayIndex; }

    public String getErrorMessage() { return this.errorMessage; }

    protected void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }

    public boolean getIsSuccessfullyModified() { return this.isSuccessfullyModified; }

    protected void setSuccessfullyModified(boolean isSuccessfullyModified) {
        this.isSuccessfullyModified = isSuccessfullyModified;
    }
}
