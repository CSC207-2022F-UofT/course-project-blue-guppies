package modify_task_use_case;

/**
 * Task Modification DsInputData Class. Instances of type ModifyTaskDsInputData are
 * passed on to the gateway to execute the use case's application logic.
 * @author Raghav Arora
 */
public class ModifyTaskDsInputData {
    private final int dayIndex;
    private final String newTitle;
    private String title;

    public ModifyTaskDsInputData(int dayIndex, String newTitle, String title) {
        this.dayIndex = dayIndex;
        this.newTitle = newTitle;
        this.title = title;
    }

    public String getNewTitle() { return this.newTitle; }

    public int getDayIndex() { return this.dayIndex; }

    public String getTitle() { return this.title; }

    public void setTitle(String title) { this.title = title; }
}
