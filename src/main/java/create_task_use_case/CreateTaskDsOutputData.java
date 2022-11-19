package create_task_use_case;

public class CreateTaskDsOutputData {
    private String title;
    private boolean completed;
    private int day;

    public CreateTaskDsOutputData(String title, boolean completed, int day){
        this.title = title;
        this.completed = completed;
        this.day = day;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public boolean getCompleted(){
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getDay(){
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
