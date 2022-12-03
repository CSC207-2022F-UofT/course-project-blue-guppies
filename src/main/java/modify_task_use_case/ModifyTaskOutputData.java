package modify_task_use_case;

/**
 * Task Modification Output Data Class. Instances of this class are returned upon the
 * execution of the application logic for this use case. The errorMessage and
 * isSuccessfullyModified instance attributes, in particular, represent whether the use
 * case logic was successfully executed.
 * @author Raghav Arora
 */
class ModifyTaskOutputData {
    private final String title;
    private final int dayIndex;
    private String errorMessage;
    private boolean isSuccessfullyModified;


    ModifyTaskOutputData(String title, int dayIndex) {
        this.title = title;
        this.dayIndex = dayIndex;
    }

    protected String getTitle() { return this.title; }

    protected int getDayIndex() { return this.dayIndex; }

    protected String getErrorMessage() { return this.errorMessage; }

    protected void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }

    protected boolean getIsSuccessfullyModified() { return this.isSuccessfullyModified; }

    protected void setSuccessfullyModified(boolean isSuccessfullyModified) {
        this.isSuccessfullyModified = isSuccessfullyModified;
    }
}
