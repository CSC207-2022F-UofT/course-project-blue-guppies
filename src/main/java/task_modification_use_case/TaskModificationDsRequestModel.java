package task_modification_use_case;

public class TaskModificationDsRequestModel {
    private int dayID;
    private String newTitle;
    private String title;

    public TaskModificationDsRequestModel(int dayId, String newTitle, String title) {
        this.dayID = dayId;
        this.newTitle = newTitle;
        this.title = title;
    }

    public String getNewTitle() { return this.newTitle; }

    public int getDayID() { return this.dayID; }

    public String getTitle() { return this.title; }

    public void setNewTitle(String newTitle) { this.newTitle = newTitle; }

    public void setTitle(String title) { this.title = title; }

    public void setDayID(int dayID) { this.dayID = dayID; }
}
