package create_task_use_case;

import java.util.Objects;

public class CreateTaskInputData {

    private String title;
    private boolean completed;
    private int day;

    public CreateTaskInputData(String title, boolean completed, String dayName){
        this.title = title;
        this.completed = completed;
        switch (dayName){
            case "Sunday":
                this.day = 0;
                break;
            case "Monday":
                this.day = 1;
                break;
            case "Tuesday":
                this.day = 2;
                break;
            case "Wednesday":
                this.day = 3;
                break;
            case "Thursday":
                this.day = 4;
                break;
            case "Friday":
                this.day = 5;
                break;
            case "Saturday":
                this.day = 6;
                break;
        }

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

    int getDay(){
        return this.day;
    }

    void setDay(int day){
        this.day = day;
    }


}
