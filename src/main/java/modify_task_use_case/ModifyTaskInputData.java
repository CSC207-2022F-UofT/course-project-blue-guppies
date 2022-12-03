package modify_task_use_case;

/**
 * Task Modification Input Data Class. Parameters passed on to the method modifyTask
 * of the Controller class are assembled into a ModifyTaskInputData object before invoking
 * the implementation of modifyTask given by the interactor/input boundary.
 * @author Raghav Arora
 */
public class ModifyTaskInputData {
    private final int dayIndex;
    private final String newTitle;
    private String title;

    public ModifyTaskInputData(int dayIndex, String newTitle, String title) {
        this.dayIndex = dayIndex;
        this.newTitle = newTitle;
        this.title = title;
    }

    public String getNewTitle() { return this.newTitle; }

    public int getDayIndex() { return this.dayIndex; }

    public String getTitle() { return this.title; }

    public void setTitle(String title) { this.title = title; }
}
