package create_task_use_case;

/**
 * Task Creation DsInputData Class. Instances of type CreateTaskDsInputData are
 * passed on to the gateway to execute the use case's application logic.
 * @author Fardin Faruk
 */
public class CreateTaskDsInputData {
    private final String title;
    private final int dayIndex;

    public CreateTaskDsInputData(String title, int dayIndex){
        this.title = title;
        this.dayIndex = dayIndex;
    }

    public String getTitle() {
        return title;
    }

    public int getDayIndex(){
        return dayIndex;
    }

}
