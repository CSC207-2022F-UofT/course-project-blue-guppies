package complete_task_use_case;

/**
 * Task Completion DsInputData Class. Instances of type CompleteTaskDsInputData are
 * passed on to the gateway to execute the use case's application logic.
 *
 * @author Fardin Faruk
 */
class CompleteTaskDsInputData {
    private final int dayIndex;
    private final String title;


    CompleteTaskDsInputData(int dayIndex, String title, boolean taskCompleted) {
        this.dayIndex = dayIndex;
        this.title = title;

    }

    protected int getDayIndex() {
        return dayIndex;
    }

    protected String getTitle() {
        return this.title;
    }

}
