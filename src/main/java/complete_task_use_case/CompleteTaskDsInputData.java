package complete_task_use_case;

/**
 * Task Completion DsInputData Class. Instances of type CompleteTaskDsInputData are
 * passed on to the gateway to execute the use case's application logic.
 * @author Fardin Faruk
 */
class CompleteTaskDsInputData {
    private final int dayIndex;
    private final String title;

    private final boolean taskCompleted;

    CompleteTaskDsInputData(int dayIndex, String title, boolean taskCompleted){
        this.dayIndex = dayIndex;
        this.title = title;
        this.taskCompleted = taskCompleted;

    }

    protected int getDayIndex() {
        return dayIndex;
    }

    protected String getTitle(){
        return this.title;
    }

    protected boolean isTaskCompleted() {return this.taskCompleted; }

}
