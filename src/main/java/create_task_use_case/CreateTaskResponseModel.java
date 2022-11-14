package create_task_use_case;

public class CreateTaskResponseModel {

    String title;
    boolean completed;

    public CreateTaskResponseModel(String title, boolean completed){
        this.title = title;
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
