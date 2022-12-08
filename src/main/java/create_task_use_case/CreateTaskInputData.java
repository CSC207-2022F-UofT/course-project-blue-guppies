package create_task_use_case;

/**
 * Task Creation Input Data Class. Parameters passed on to the method createTask
 * of the Controller class are assembled into CreateTaskInputData object before invoking
 * the implementation of createTask given by the interactor/input boundary.
 * @author Fardin Faruk
 */
public class CreateTaskInputData {

    private final String title;
    private final int dayIndex;

    public CreateTaskInputData(String title, int dayIndex){
        this.title = title;
        this.dayIndex = dayIndex;
        }


    String getTitle(){
        return title;
    }

    int getDayIndex(){
        return dayIndex;
    }

}
