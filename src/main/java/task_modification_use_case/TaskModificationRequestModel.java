package task_modification_use_case;

public class TaskModificationRequestModel {
    private int dayID;
    private String newTitle;
    private String title;
    private boolean isComplete;

    public TaskModificationRequestModel(int dayId, String newTitle, String title, boolean isComplete) {
        this.dayID = dayId;
        this.newTitle = newTitle;
        this.title = title;
        this.isComplete = isComplete;
    }

    public String getNewTitle() { return this.newTitle; }

    public int getDayID() { return this.dayID; }

    public String getTitle() { return this.title; }

    public boolean getCompletionStatus() { return this.isComplete; }

    public void setNewTitle(String newTitle) { this.newTitle = newTitle; }

    public void setTitle(String title) { this.title = title; }

    public void setCompletionStatus(boolean isComplete) { this.isComplete = isComplete; }

    public void setDayID(int dayID) { this.dayID = dayID; }
}
