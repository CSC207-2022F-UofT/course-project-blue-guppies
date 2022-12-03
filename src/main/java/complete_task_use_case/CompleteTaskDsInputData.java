package complete_task_use_case;

/**
 * Task Completion DsInputData Class. Instances of type CompleteTaskDsInputData are
 * passed on to the gateway to execute the use case's application logic.
 * @author Fardin Faruk
 */
public class CompleteTaskDsInputData {
    private final int dayIndex;
    private final String title;



    public CompleteTaskDsInputData(int dayIndex, String title){
        this.dayIndex = dayIndex;
        this.title = title;
    }

    public int getDayIndex() {
        return dayIndex;
    }

    public String getTitle(){
        return this.title;
    }

}
