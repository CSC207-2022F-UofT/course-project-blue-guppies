package create_task_use_case;

public class CreateTaskRequestModel {

    private String title;
    private boolean completed;

    public CreateTaskRequestModel(String title, boolean completed){
        this.title = title;
        this.completed = completed;
    }

    String getTitle(){
        return title;
    }

    void setTitle(String title){
        this.title = title;
    }

    boolean getCompleted(){
        return completed;
    }

    void setCompleted(boolean completed){
        this.completed = completed;
    }

}
