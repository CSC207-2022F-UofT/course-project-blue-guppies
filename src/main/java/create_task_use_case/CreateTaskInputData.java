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
                day = 0;
                break;
            case "Monday":
                day = 1;
                break;
            case "Tuesday":
                day = 2;
                break;
            case "Wednesday":
                day = 3;
                break;
            case "Thursday":
                day = 4;
                break;
            case "Friday":
                day = 5;
                break;
            case "Saturday":
                day = 6;
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
        return day;
    }

    void setDay(int day){
        this.day = day;
    }


}
