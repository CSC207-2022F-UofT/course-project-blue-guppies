package complete_task_use_case;

public class CompleteTaskInputData {
    private int dayID;
    private String title;

    public CompleteTaskInputData(int dayID, String title){
        this.dayID = dayID;
        this.title = title;
    }

    public int getDayID() {
        return dayID;
    }

    public void setDayID(int dayID) {
        this.dayID = dayID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
