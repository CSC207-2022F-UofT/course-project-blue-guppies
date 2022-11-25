package complete_task_use_case;

public class CompleteTaskOutputData {
    String title;
    int dayID;
    boolean isSuccessfullyCreated;


    public CompleteTaskOutputData(String title, int dayID){
        this.title = title;
        this.dayID = dayID;
        this.isSuccessfullyCreated = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDayID() {
        return dayID;
    }

    public void setDayID(int dayID) {
        this.dayID = dayID;
    }

    public boolean isSuccessfullyCreated() {
        return isSuccessfullyCreated;
    }

    public void setSuccessfullyCreated(boolean successfullyCreated) {
        isSuccessfullyCreated = successfullyCreated;
    }
}
