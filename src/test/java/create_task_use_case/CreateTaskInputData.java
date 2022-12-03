package create_task_use_case;

/**
 * Task Creation Input Data Class. Parameters passed on to the method createTask
 * of the Controller class are assembled into CreateTaskInputData object before invoking
 * the implementation of createTask given by the interactor/input boundary.
 * @author Fardin Faruk
 */
public class CreateTaskInputData {

    private String title;
    private int dayIndex;

    public CreateTaskInputData(String title, String dayIndex){
        this.title = title;

        switch (dayIndex) {
            case "Sunday" -> this.dayIndex = 0;
            case "Monday" -> this.dayIndex = 1;
            case "Tuesday" -> this.dayIndex = 2;
            case "Wednesday" -> this.dayIndex = 3;
            case "Thursday" -> this.dayIndex = 4;
            case "Friday" -> this.dayIndex = 5;
            default -> this.dayIndex = 6;
            // if no match assume Saturday
        }
        }


    String getTitle(){
        return title;
    }

    void setTitle(String title){
        this.title = title;
    }

    int getDayIndex(){
        return dayIndex;
    }

}
