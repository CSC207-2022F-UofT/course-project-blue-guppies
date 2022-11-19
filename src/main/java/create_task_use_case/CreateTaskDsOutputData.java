package create_task_use_case;

public class CreateTaskDsOutputData {
    private String title;
    private boolean completed;

    public CreateTaskDsOutputData(String title, boolean completed){
        this.title = title;
        this.completed = completed;
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
}
