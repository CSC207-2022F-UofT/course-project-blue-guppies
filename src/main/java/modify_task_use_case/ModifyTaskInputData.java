package modify_task_use_case;

/**
 * Task Modification Input Data Class. Parameters passed on to the method modifyTask
 * of the Controller class are assembled into a ModifyTaskInputData object before invoking
 * the implementation of modifyTask given by the interactor/input boundary.
 * @author Raghav Arora
 */
class ModifyTaskInputData {
    private final int dayIndex;
    private final String newTitle;
    private String title;

    ModifyTaskInputData(int dayIndex, String newTitle, String title) {
        this.dayIndex = dayIndex;
        this.newTitle = newTitle;
        this.title = title;
    }

    protected String getNewTitle() { return this.newTitle; }

    protected int getDayIndex() { return this.dayIndex; }

    protected String getTitle() { return this.title; }

}
