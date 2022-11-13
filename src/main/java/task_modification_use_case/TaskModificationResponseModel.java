package task_modification_use_case;

public class TaskModificationResponseModel {
    private String title;
    private boolean isComplete;

    public TaskModificationResponseModel(String title, boolean isComplete) {
        this.title = title;
        this.isComplete = isComplete;
    }

    String getTitle() { return this.title; }

    boolean getCompletionStatus() { return this.isComplete; }

    void setTitle(String title) { this.title = title; }

    void setCompletionStatus(boolean isComplete) { this.isComplete = isComplete; }
}
