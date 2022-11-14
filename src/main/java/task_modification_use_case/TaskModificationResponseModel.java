package task_modification_use_case;

public class TaskModificationResponseModel {
    private String title;
    private int dayId;

    public TaskModificationResponseModel(String title, int dayId) {
        this.title = title;
        this.dayId = dayId;
    }

    String getTitle() { return this.title; }

    void setTitle(String title) { this.title = title; }

    int getDayId() { return this.dayId; }

    public void setDayId(int dayId) { this.dayId = dayId; }
}
