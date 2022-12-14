package complete_task_use_case;

/**
 * Task Completion Input Data Class. Parameters passed on to the method completeTask
 * of the Controller class are assembled into CompleteTaskInputData object before invoking
 * the implementation of completeTask given by the interactor/input boundary.
 *
 * @author Fardin Faruk
 */
class CompleteTaskInputData {
    private final int dayIndex;
    private final String title;
    private final boolean taskCompleted;

    CompleteTaskInputData(int dayIndex, String title, boolean taskCompleted) {
        this.title = title;
        this.dayIndex = dayIndex;
        this.taskCompleted = taskCompleted;
    }

    protected int getDayIndex() {
        return dayIndex;
    }

    protected String getTitle() {
        return title;
    }

    protected boolean isTaskCompleted() {
        return taskCompleted;
    }

}
